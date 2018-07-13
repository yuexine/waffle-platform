package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 基础用户信息
 *
 * @author yuexin
 * @since 1.0
 */
@Data
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
    @OneToOne(mappedBy = "user")
    private SysUserEntity sysUser;

    /**
     * 对应的客户端用户
     */
    @OneToOne(mappedBy = "user")
    private ClientUserEntity clientUser;
}
