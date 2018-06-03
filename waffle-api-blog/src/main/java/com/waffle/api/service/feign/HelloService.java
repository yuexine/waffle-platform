package com.waffle.api.service.feign;

import com.waffle.api.service.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yuexin
 */
@FeignClient(value = "waffle-notification", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String getHello();
}
