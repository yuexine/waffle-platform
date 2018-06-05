package com.waffle.api.blog.service.common;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author yuexin
 */
public class DefaultAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1L);
    }
}
