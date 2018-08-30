package com.waffle.api.blog.config;

import com.waffle.api.blog.json.JsonFilterReturnHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author yuexin
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final JsonFilterReturnHandler jsonFilterReturnHandler;

    @Autowired
    public WebConfiguration(JsonFilterReturnHandler jsonFilterReturnHandler) {
        this.jsonFilterReturnHandler = jsonFilterReturnHandler;
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(jsonFilterReturnHandler);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*/*")
                .allowedMethods("*")
                .maxAge(120);
    }
}
