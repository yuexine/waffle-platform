package com.waffle.component.kafka.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yuexin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({KafkaConfiguration.class})
public @interface EnableKafkaComponent {
}
