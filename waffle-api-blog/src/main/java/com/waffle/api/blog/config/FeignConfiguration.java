package com.waffle.api.blog.config;

import com.waffle.api.blog.TokenContextHolder;
import com.waffle.api.blog.service.TokenService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuexin
 */
@Configuration
public class FeignConfiguration {

    @Autowired
    private TokenService tokenService;

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    public class FeignBasicAuthRequestInterceptor  implements RequestInterceptor {

        public FeignBasicAuthRequestInterceptor() {

        }

        @Override
        public void apply(RequestTemplate template) {
            template.header("Authorization", TokenContextHolder.getInstance().getToken());
        }
    }

}
