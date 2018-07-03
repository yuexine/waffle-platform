package com.waffle.api.blog.service;

import com.google.gson.Gson;
import com.waffle.api.blog.service.feign.OAuthService;
import com.waffle.api.blog.service.feign.fallback.OAuthServiceFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yuexin
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private OAuthService oAuthService;
    @Override
    public String applyToken() {
        String token = oAuthService.applyToken("user_1","123456", "password", "select", "client_2", "123456");
        Map<String,Object> tokenMap = new Gson().fromJson(token, Map.class);
        return (String)tokenMap.get("token_type") + tokenMap.get("access_token");
    }
}
