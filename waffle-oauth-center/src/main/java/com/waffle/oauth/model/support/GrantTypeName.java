package com.waffle.oauth.model.support;

/**
 * @author yuexin
 */
public enum GrantTypeName {
    CLIENT_CREDENTIALS("client_credentials");

    GrantTypeName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
