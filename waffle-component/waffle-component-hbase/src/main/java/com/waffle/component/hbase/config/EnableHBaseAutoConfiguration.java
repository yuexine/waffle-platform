package com.waffle.component.hbase.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yuexin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({HBaseAutoConfiguration.class})
public @interface EnableHBaseAutoConfiguration {

}
