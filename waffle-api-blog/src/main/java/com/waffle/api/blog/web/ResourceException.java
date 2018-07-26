package com.waffle.api.blog.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@RestControllerAdvice
public class ResourceException {

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public ResponseEntity handleNullPointerException(NullPointerException exception) {
        exceptionPrinter(exception);
        return ResponseEntity.status(HttpStatus.OK).body("不走心>>");
    }

    private void exceptionPrinter(Exception exception) {
        log.error("====++++==== exception =====++++==== {}", exception);
    }
}
