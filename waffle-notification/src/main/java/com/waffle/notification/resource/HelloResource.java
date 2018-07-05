package com.waffle.notification.resource;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuexin
 */
@RestController
public class HelloResource {

    @GetMapping(value = "hello")
    public String getHello(HttpServletRequest request) throws InterruptedException {
        Thread.sleep(7500);
        System.out.println(request.getHeader("Authorization"));
        return "Hello,World!";
    }
}
