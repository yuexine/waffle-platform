package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 基础用户信息
 *
 * @author yuexin
 */
@Data
@MappedSuperclass
public class BaseUserInfo extends BaseTimedModel {

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "secret")
    private String secret;
}
