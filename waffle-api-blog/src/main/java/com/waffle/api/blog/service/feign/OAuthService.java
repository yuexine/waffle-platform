package com.waffle.api.blog.service.feign;

import com.waffle.api.blog.service.feign.fallback.OAuthServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuexin
 */
@FeignClient(value = "waffle-oauth-center", fallback = OAuthServiceFallback.class)
public interface OAuthService {

    @GetMapping(value = "oauth/token")
    String applyToken(@RequestParam(value = "username") String username,
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "grant_type") String grant_type,
                      @RequestParam(value = "scope") String scope,
                      @RequestParam(value = "client_id") String client_id,
                      @RequestParam(value = "client_secret") String client_secret);

    @GetMapping(value = "/")
    String test();
}
