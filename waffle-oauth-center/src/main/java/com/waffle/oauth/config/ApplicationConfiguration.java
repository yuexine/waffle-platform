package com.waffle.oauth.config;

import com.waffle.oauth.service.DatabaseClientDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * @author yuexin
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new DatabaseClientDetailsService();
    }
}
