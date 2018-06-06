package com.waffle.api.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author yuexin
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.waffle.api.blog.repository.jpa")
public class JPAConfiguration {
}
