package com.waffle.oauth.model;

import com.waffle.oauth.model.support.GrantType;
import com.waffle.oauth.model.support.Scope;
import lombok.Data;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yuexin
 */

public class DefaultClientDetails extends BaseClientDetails {

    private Long id;

    private String clientId;

    private String  clientSecret;

    private Set<Scope> scopes;

    private Set<Resource> resources;

    private Set<GrantType> authorizedGrantTypes;

    private Set<String> registeredRedirectUris;

    private Set<String> autoApproveScopes;

    private Set authorities;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

}
