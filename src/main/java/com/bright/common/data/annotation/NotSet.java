package com.bright.common.data.annotation;

import java.lang.annotation.*;

/**
 * 不需要赋值
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface NotSet {

    boolean value() default true;

    String defaultValue() default "";
}
