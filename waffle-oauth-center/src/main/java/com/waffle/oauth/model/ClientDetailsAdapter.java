package com.waffle.oauth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuexin
 */
public class ClientDetailsAdapter implements ClientDetails {

    private DefaultClientDetails clientDetails;

    public ClientDetailsAdapter(DefaultClientDetails client) {
        this.clientDetails = client;
    }

    @Override
    public String getClientId() {
        return clientDetails.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return clientDetails.getResources().stream()
                .map(Resource::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return this.getClientSecret() != null;
    }

    @Override
    public String getClientSecret() {
        return clientDetails.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return clientDetails.getScopes().stream().anyMatch(clientDetail -> !clientDetail.getRemoved());
    }

    @Override
    public Set<String> getScope() {
        return clientDetails.getScopes().stream()
                .filter(scope -> !scope.getRemoved())
                .map(scope -> scope.getName().name())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return clientDetails.getAuthorizedGrantTypeNames().stream()
                .filter(grantType -> !grantType.getRemoved())
                .map(grantType -> grantType.getType().name())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return clientDetails.getRegisteredRedirectUris().stream()
                .filter(redirectUri -> !redirectUri.getRemoved())
                .map(RedirectUri::getUri)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientDetails.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientDetails.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        Set<String> scopes = clientDetails.getScopes().stream()
                .filter(s -> !s.getRemoved())
                .filter(Scope::getAutoApprove)
                .map(s -> s.getName().name())
                .collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(scopes)) {
            return false;
        } else {
            return scopes.contains(scope);
        }
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        Map<String, Object> additionalInformation = new HashMap<>();
        clientDetails.getAdditionalInformation().forEach(information -> additionalInformation.put(information.getName(), information.getValue()));
        return additionalInformation;
    }
}
