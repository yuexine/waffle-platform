package com.waffle.api.resource;

import com.waffle.api.service.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class HelloResource {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String getHello() {
        return helloService.getHello();
    }
}
