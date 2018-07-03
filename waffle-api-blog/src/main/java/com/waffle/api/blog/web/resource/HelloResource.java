package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.service.feign.HelloService;
import com.waffle.api.blog.service.feign.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class HelloResource {

    @Autowired
    private HelloService helloService;

    @Autowired
    private OAuthService oAuthService;

    @GetMapping("/hi")
    public String getHello() {
        return helloService.getHello();
    }


    @GetMapping("/hi1")
    public String getHello1() {
        return oAuthService.test();
    }


    @GetMapping("/hi2")
    public String getHello2() {
        return oAuthService.applyToken("user_1","123456", "password", "select", "client_2", "123456");
    }

}
