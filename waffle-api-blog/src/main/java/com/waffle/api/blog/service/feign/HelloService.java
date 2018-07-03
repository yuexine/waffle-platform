package com.waffle.api.blog.service.feign;

import com.waffle.api.blog.config.FeignConfiguration;
import com.waffle.api.blog.service.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yuexin
 */
@FeignClient(value = "waffle-notification", fallback = HelloServiceFallback.class, configuration = FeignConfiguration.class)
public interface HelloService {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String getHello();
}
