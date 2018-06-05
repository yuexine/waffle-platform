package com.waffle.api.blog.config;

import com.waffle.api.blog.service.common.DefaultAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author yuexin
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<Long> auditorAware() {
        return new DefaultAuditorAware();
    }
}
