package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 基础用户信息
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@MappedSuperclass
public class BaseUserInfo extends BaseTimedModel {

    /**
     * 登录名
     */
    @Column(name = "login")
    private String login;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * email
     */
    @Column(name = "email")
    private String email;

    /**
     * phone
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 加密后的密钥
     */
    @Column(name = "secret")
    private String secret;
}
