package com.waffle.oauth.service;

import java.util.UUID;

/**
 * @author yuexin
 */
public class UUIDSecretGenerator implements SecretGenerator {
    @Override
    public String generate() {
        //TODO
        return UUID.randomUUID().toString();
    }
}
