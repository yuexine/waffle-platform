package com.waffle.oauth.model.support;

/**
 * @author yuexin
 */
public enum GrantTypeName {
    /**
     * 客户端授权
     */
    CLIENT_CREDENTIALS("client_credentials");

    GrantTypeName(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
