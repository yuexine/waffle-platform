package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * 客户端详细信息
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.CLIENT_DETAIL)
public class ClientDetailEntity extends BaseTimedModel {

    /**
     * 客户端接入ID
     */
    @Column(name = "client_id", nullable = false)
    private String clientId;

    /**
     * 客户端接入密钥，加密后存储
     */
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    /**
     * 客户端scope
     */
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER)
    private Set<ScopeEntity> scopes;

    /**
     * 为当前客户端接入的资源
     */
    @ManyToMany(mappedBy = "clientDetailsSet", fetch = FetchType.EAGER)
    private Set<ResourceEntity> resource;

    /**
     * 客户端支持的授权类型
     */
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER)
    private Set<GrantTypeEntity> authorizedGrantTypeNames;

    /**
     * 客户端受信任的重定向URL
     */
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER)
    private Set<RedirectUriEntity> registeredRedirectUris;

    /**
     * access_token 有效时间
     */
    @Column(name = "access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    /**
     * refresh token 有效时间
     */
    @Column(name = "refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

    /**
     * 客户端附加信息
     */
    @OneToMany(mappedBy = "clientDetails")
    private Set<ClientAdditionalInformationEntity> additionalInformation;

    /**
     * 客户端基本信息
     */
    @OneToOne(mappedBy = "clientDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClientEntity client;

}
