package com.waffle.api.blog.config;

import com.waffle.api.blog.service.common.file.AliOssStorageService;
import com.waffle.api.blog.service.common.file.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuexin
 */
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public FileStorage fileStorage() {
        return new AliOssStorageService(applicationProperties);
    }

}
