package com.waffle.oauth.service;

import com.waffle.oauth.exception.UserNotActivatedException;
import com.waffle.oauth.model.BaseUserEntity;
import com.waffle.oauth.repository.BaseUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yuexin
 */
@Slf4j
@Service
public class UserDetailService implements UserDetailsService {

    private BaseUserRepository baseUserRepository;

    @Autowired
    public UserDetailService(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Override
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
}
