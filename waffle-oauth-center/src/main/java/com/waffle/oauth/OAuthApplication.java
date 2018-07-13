package com.waffle.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
@SpringBootApplication
public class OAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello, I am OAuth Application";
    }

}
