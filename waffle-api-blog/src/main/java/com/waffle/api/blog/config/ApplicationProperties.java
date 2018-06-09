package com.waffle.api.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yuexin
 */
@Data
@Component
@ConfigurationProperties(prefix = "application", ignoreInvalidFields = true)
public class ApplicationProperties {

    private DataSourceProp dataSource = new DataSourceProp();

    private AliOSSProp aliOss = new AliOSSProp();

    @Data
    public static class DataSourceProp {

        private String url;

        private String username;

        private String password;

        private String driverClass;
    }

    @Data
    public class AliOSSProp {

        private String endpoint;

        private String accessKeyId;

        private String accessKeySecret;

        private String bucket;
    }
}
