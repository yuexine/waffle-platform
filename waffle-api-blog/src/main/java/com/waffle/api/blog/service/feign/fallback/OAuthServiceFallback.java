package com.waffle.api.blog.service.feign.fallback;

import com.waffle.api.blog.service.feign.OAuthService;
import org.springframework.stereotype.Service;

/**
 * @author yuexin
 */
@Service
public class OAuthServiceFallback implements OAuthService {
    @Override
    public String applyToken(String username, String password, String grant_type, String scope, String client_id, String client_secret) {
        return null;
    }

    @Override
    public String test() {
        return null;
    }
}
