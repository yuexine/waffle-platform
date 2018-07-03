package com.waffle.api.blog.service;

import com.waffle.api.blog.TokenContextHolder;
import com.waffle.api.blog.service.feign.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author yuexin
 */
@Component
public class InitToken implements ApplicationRunner {

    @Autowired
    private TokenService tokenService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TokenContextHolder.getInstance().setToken(tokenService.applyToken());
    }
}
