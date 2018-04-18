package com.waffle.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yuexin
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServer {
    static Logger logger = LoggerFactory.getLogger(ConfigServer.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
}
