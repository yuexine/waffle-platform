package com.waffle.notification.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class HelloResource {

    @GetMapping(value = "hello")
    public String getHello() throws InterruptedException {
        Thread.sleep(5500);
        return "Hello,World!";
    }
}
