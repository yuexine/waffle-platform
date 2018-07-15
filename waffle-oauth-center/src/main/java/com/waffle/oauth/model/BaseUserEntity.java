package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 基础用户信息
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.BASE_USER)
public class BaseUserEntity extends BaseTimedModel {

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
     * 被删除的
     */
    @Column(name = "removed")
    private Boolean removed = false;

    /**
     * 激活返回true
     */
    @Column(name = "activated")
    private Boolean activated = false;

    /**
     * 加密后的密钥
     */
    @Column(name = "secret")
    private String secret;

    @ManyToMany
    @JoinTable(name = "roles_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> roles = new HashSet<>();

    /**
     * 对应的系统用户
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private SysUserEntity sysUser;

    /**
     * 对应的客户端用户
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private ClientUserEntity clientUser;
}
