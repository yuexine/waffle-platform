package com.waffle.oauth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 抛出这个异常当客户端详细找不到
 *
 * @author yuexin
 * @since 1.0
 */
public class ClientDetailsNotFoundException extends AuthenticationException {

    public ClientDetailsNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public ClientDetailsNotFoundException(String msg) {
        super(msg);
    }

}
