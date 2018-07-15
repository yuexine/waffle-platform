package com.waffle.oauth.model.support;

/**
 * @author yuexin
 */
public enum ScopeName {
    /**
     *
     */
    READ("read"),

    /**
     *
     */
    WRITE("write"),

    /**
     *
     */
    TRUST("trust");

    private String value;

    ScopeName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
