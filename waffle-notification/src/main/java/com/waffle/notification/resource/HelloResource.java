package com.waffle.notification.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class HelloResource {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello,World!";
    }
}
