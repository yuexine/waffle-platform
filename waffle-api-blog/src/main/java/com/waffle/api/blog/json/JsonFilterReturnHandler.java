package com.waffle.api.blog.json;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author yuexin
 * @since 1.0
 */
@Component
public class JsonFilterReturnHandler implements HandlerMethodReturnValueHandler, BeanPostProcessor {

    private List<ResponseBodyAdvice<Object>> advices = new ArrayList<>();

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return returnType.getMethodAnnotation(JSON.class) != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);

        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);

        Annotation[] annotations = returnType.getMethodAnnotations();

        JsonSerializer jsonSerializer = new JsonSerializer();

        Arrays.asList(annotations).forEach(annotation -> {
            if (annotation instanceof JSON) {
                jsonSerializer.filter((JSON) annotation);
            } else if (annotation instanceof JSONS) {
                Arrays.asList(((JSONS) annotation).value()).forEach(jsonSerializer::filter);
            }
        });

        assert response != null;
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(jsonSerializer.toJson(returnValue));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ResponseBodyAdvice) {
            advices.add((ResponseBodyAdvice<Object>) bean);
        } else if (bean instanceof RequestMappingHandlerAdapter) {
            List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(
                    Objects.requireNonNull(((RequestMappingHandlerAdapter) bean).getReturnValueHandlers()));
            JsonFilterReturnHandler jsonHandler = null;
            for (int i = 0; i < handlers.size(); i++) {
                HandlerMethodReturnValueHandler handler = handlers.get(i);
                if (handler instanceof JsonFilterReturnHandler) {
                    jsonHandler = (JsonFilterReturnHandler) handler;
                    break;
                }
            }
            if (jsonHandler != null) {
                handlers.remove(jsonHandler);
                handlers.add(0, jsonHandler);
                ((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(handlers);
            }
        }
        return bean;
    }
}
