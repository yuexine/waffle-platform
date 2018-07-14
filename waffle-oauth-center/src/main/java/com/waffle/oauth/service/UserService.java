package com.waffle.oauth.service;

import com.waffle.oauth.model.BaseUserEntity;

/**
 * @author yuexin
 * @since 1.0
 */
public interface UserService {

    /**
     * 注册新用户
     *
     * @param username
     * @param password
     * @param phone
     * @param email
     * @return
     */
    BaseUserEntity register(String username, String password, String phone, String email);
}
