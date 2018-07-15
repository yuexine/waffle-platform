package com.waffle.oauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 参数配置对象
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private Integer refreshTokenValiditySeconds = 12 * 60 * 60;

    private Integer accessTokenValiditySeconds = 12 * 60 * 60;

    private String resourceSignKey = "yx92tb%Tg365";

}
