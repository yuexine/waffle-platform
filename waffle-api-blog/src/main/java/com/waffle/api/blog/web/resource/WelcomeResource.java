package com.waffle.api.blog.web.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class WelcomeResource {

    @GetMapping("/")
    public String getHello() {
        return "Welcome To Blog API.";
    }

}
