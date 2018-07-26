package com.waffle.api.blog.json;

import java.lang.annotation.*;

/**
 * @author yuexin
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(JSONS.class)
public @interface JSON {

    Class<?> clazz();

    String include() default "";

    String filter() default "";
}
