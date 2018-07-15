package com.waffle.oauth.service;

import com.waffle.oauth.exception.ClientDetailsNotFoundException;
import com.waffle.oauth.exception.UserNotActivatedException;
import com.waffle.oauth.model.*;
import com.waffle.oauth.model.support.RoleName;
import com.waffle.oauth.repository.BaseUserRepository;
import com.waffle.oauth.repository.ClientDetailsRepository;
import com.waffle.oauth.repository.ClientUserRepository;
import com.waffle.oauth.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户及客户端用户实现
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@Service(value = "localClientDetailsService")
public class UserDetailServiceImpl implements UserService, ClientUserService, UserDetailsService, ClientDetailsService {

    private final BaseUserRepository baseUserRepository;

    private final RoleRepository roleRepository;

    private final ClientDetailsRepository clientDetailsRepository;

    private final ClientUserRepository clientUserRepository;

    @Autowired
    public UserDetailServiceImpl(BaseUserRepository baseUserRepository, RoleRepository roleRepository, ClientDetailsRepository clientDetailsRepository, ClientUserRepository clientUserRepository) {
        this.baseUserRepository = baseUserRepository;
        this.roleRepository = roleRepository;
        this.clientDetailsRepository = clientDetailsRepository;
        this.clientUserRepository = clientUserRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowercaseUsername = username.toLowerCase();
        Optional<BaseUserEntity> baseUserFromDb = baseUserRepository.findByLoginAndRemovedFalse(lowercaseUsername);

        return baseUserFromDb.map(user -> {
            if (!user.getActivated()) {
                throw new UserNotActivatedException("User " + username + " was not activated");
            }
            Set<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                    .filter(role -> !role.getRemoved())
                    .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toSet());
            return new User(username, user.getSecret(), grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the Db"));
    }

    @Override
    @Transactional
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        log.debug("load client start, id is {}", clientId);
        Optional<ClientDetailEntity> clientDetailsFromDb = clientDetailsRepository.findByClientId(clientId);

        return clientDetailsFromDb
                .map(ClientDetailsAdapter::new)
                .orElseThrow(() -> new ClientDetailsNotFoundException("Client " + clientId + "was not found in the Db"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseUserEntity registerUser(String username, String password, String phone, String email) {
        BaseUserEntity baseUser = buildBaseUser(username, password, email);
        choiceRoles(baseUser, RoleName.ROLE_USER);
        return baseUserRepository.save(baseUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClientUserEntity registerClientUser(String username, String email, String password, String phone) {
        BaseUserEntity baseUser = buildBaseUser(username, password, email);
        choiceRoles(baseUser, RoleName.ROLE_CLIENT_USER);
        ClientUserEntity clientUserEntity = new ClientUserEntity();
        clientUserEntity.setUser(baseUser);
        return clientUserRepository.save(clientUserEntity);
    }

    private void choiceRoles(BaseUserEntity baseUser, RoleName... roleNames) {
        Set<RoleEntity> roles = new HashSet<>(roleNames.length);
        for (RoleName roleName : roleNames) {
            RoleEntity roleEntity = roleRepository.findByNameAndRemovedFalse(roleName).orElseThrow(NullPointerException::new);
            roles.add(roleEntity);
        }
        baseUser.setRoles(roles);
    }

    private BaseUserEntity buildBaseUser(String username, String password, String email) {
        BaseUserEntity baseUser = new BaseUserEntity();
        baseUser.setEmail(email);
        baseUser.setLogin(username);
        baseUser.setName(username);
        baseUser.setActivated(true);
        baseUser.setSecret(password);
        return baseUser;
    }

}
