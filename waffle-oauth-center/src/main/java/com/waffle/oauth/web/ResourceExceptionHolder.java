package com.waffle.oauth.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 *
 * @author yuexin
 * @since
 */
@Slf4j
@ControllerAdvice(basePackageClasses = ResourceExceptionHolder.class)
public class ResourceExceptionHolder {

    @ExceptionHandler({NullPointerException.class})
    @ResponseBody
    public String handleNullPointException(NullPointerException exception) {
        log.error("Oh, No >>", exception);
        return "不走心...";
    }
}
