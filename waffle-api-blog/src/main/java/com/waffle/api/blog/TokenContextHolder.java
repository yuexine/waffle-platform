package com.waffle.api.blog;

/**
 * @author yuexin
 */
public class TokenContextHolder {
    private static TokenContextHolder ourInstance = new TokenContextHolder();

    public static TokenContextHolder getInstance() {
        return ourInstance;
    }

    private TokenContextHolder() {
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
