package com.waffle.oauth.service;

import com.waffle.oauth.model.ClientUserEntity;

/**
 * @author yuexin
 */
public interface ClientUserService {
    /**
     * 注册一个新的客户端用户
     *
     * @param username 用户名
     * @param email    email
     * @param password 密钥
     * @param phone    联系号
     * @return 创建后的对象
     */
    ClientUserEntity registerClientUser(String username, String email, String password, String phone);
}
