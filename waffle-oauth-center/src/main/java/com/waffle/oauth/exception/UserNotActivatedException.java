package com.waffle.oauth.exception;

/**
 * @author yuexin
 */
public class UserNotActivatedException extends RuntimeException {

    private String message;

    public UserNotActivatedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
