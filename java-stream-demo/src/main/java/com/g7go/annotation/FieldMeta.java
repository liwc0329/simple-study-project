package com.g7go.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author Mr_Lee
 * @date 2019-10-12 18:08
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMeta {

    boolean id() default true;

    String name() default "default";

    int order() default 0;

    String description() default "description";
}
