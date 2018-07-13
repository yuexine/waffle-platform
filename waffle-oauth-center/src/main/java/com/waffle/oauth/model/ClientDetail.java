package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = TableName.CLIENT_DETAIL)
public class ClientDetail extends BaseTimedModel {

    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @OneToMany(mappedBy = "clientDetails")
    private Set<Scope> scopes;

    @ManyToMany(mappedBy = "clientDetailsSet")
    private Set<Resource> resources;

    @OneToMany(mappedBy = "clientDetails")
    private Set<GrantType> authorizedGrantTypeNames;

    @OneToMany(mappedBy = "clientDetails")
    private Set<RedirectUri> registeredRedirectUris;

    @Column(name = "access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

    @OneToMany(mappedBy = "clientDetails")
    private Set<ClientAdditionalInformation> additionalInformation;

    @OneToOne(mappedBy = "clientDetail")
    private Client client;

}
