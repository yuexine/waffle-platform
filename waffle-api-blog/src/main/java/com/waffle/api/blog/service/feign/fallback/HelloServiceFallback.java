package com.waffle.api.blog.service.feign.fallback;

import com.waffle.api.blog.service.feign.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author yuexin
 */
@Service
public class HelloServiceFallback implements HelloService {
    @Override
    public String getHello() {
        return "sorry, no message";
    }
}
