package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.User;
import com.waffle.api.blog.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author yuexin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Long> registerUser(User user) {
        user = userRepository.save(user);
        //publish email for validate
        return Optional.of(user.getId());
    }
}
