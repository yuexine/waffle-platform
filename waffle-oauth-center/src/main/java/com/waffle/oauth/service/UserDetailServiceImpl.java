package com.waffle.oauth.service;

import com.waffle.oauth.exception.UserNotActivatedException;
import com.waffle.oauth.model.BaseUserEntity;
import com.waffle.oauth.model.RoleEntity;
import com.waffle.oauth.model.support.RoleName;
import com.waffle.oauth.repository.BaseUserRepository;
import com.waffle.oauth.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 实现
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserService, UserDetailsService {

    private final BaseUserRepository baseUserRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserDetailServiceImpl(BaseUserRepository baseUserRepository, RoleRepository roleRepository) {
        this.baseUserRepository = baseUserRepository;
        this.roleRepository = roleRepository;
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
    @Transactional(rollbackFor = Exception.class)
    public BaseUserEntity register(String username, String password, String phone, String email) {
        BaseUserEntity baseUser = new BaseUserEntity();
        baseUser.setEmail(email);
        baseUser.setLogin(username);
        baseUser.setName(username);
        baseUser.setActivated(true);
        baseUser.setSecret(password);
        RoleEntity roleEntity = roleRepository.findByNameAndRemovedFalse(RoleName.ROLE_USER).orElseThrow(NullPointerException::new);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntity);
        baseUser.setRoles(roles);
        return baseUserRepository.save(baseUser);
    }
}
