package com.waffle.oauth.config;

import com.waffle.oauth.service.DefaultAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SQL审计
 *
 * @author yuexin
 * @since 1.0
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new DefaultAuditorAware();
    }
}
