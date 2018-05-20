package com.waffle.sso;

import com.waffle.component.hbase.config.EnableHBaseComponent;
import com.waffle.component.kafka.config.KafkaConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
@SpringBootApplication
@Import(value = {KafkaConfiguration.class})
@EnableHBaseComponent
public class SsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }

    @Value("${foo}")
    private String foo;

    @GetMapping("/")
    public String home() {
        return "Hello, I am SSO Application" + foo;
    }

}
