package com.waffle.api.blog.json;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author yuexin
 * @since 1.0
 */
public class JsonFilterReturnHandler implements HandlerMethodReturnValueHandler {
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
}
