package com.waffle.oauth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 适配接入客户端到待验证的客户端信息
 *
 * @author yuexin
 * @since 1.0
 */
public class ClientDetailsAdapter implements ClientDetails {

    private ClientDetailEntity clientDetail;

    public ClientDetailsAdapter(ClientDetailEntity client) {
        this.clientDetail = client;
    }

    @Override
    public String getClientId() {
        return clientDetail.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return clientDetail.getResource().stream()
                .map(ResourceEntity::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return this.getClientSecret() != null;
    }

    @Override
    public String getClientSecret() {
        return clientDetail.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return clientDetail.getScopes().stream().anyMatch(clientDetail -> !clientDetail.getRemoved());
    }

    @Override
    public Set<String> getScope() {
        return clientDetail.getScopes().stream()
                .filter(scope -> !scope.getRemoved())
                .map(scope -> scope.getName().name())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return clientDetail.getAuthorizedGrantTypeNames().stream()
                .filter(grantType -> !grantType.getRemoved())
                .map(grantType -> grantType.getType().name())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return clientDetail.getRegisteredRedirectUris().stream()
                .filter(redirectUri -> !redirectUri.getRemoved())
                .map(RedirectUriEntity::getUri)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientDetail.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientDetail.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        Set<String> scopes = clientDetail.getScopes().stream()
                .filter(s -> !s.getRemoved())
                .filter(ScopeEntity::getAutoApprove)
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
        clientDetail.getAdditionalInformation().forEach(information -> additionalInformation.put(information.getName(), information.getValue()));
        return additionalInformation;
    }
}
