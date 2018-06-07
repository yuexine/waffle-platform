package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.User;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface UserService {

    Optional<Long> registerUser(User user);
}
