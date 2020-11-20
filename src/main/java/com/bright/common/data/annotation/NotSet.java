package com.bright.common.data.annotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

/**
 * 不需要赋值
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface NotSet {

    boolean value() default true;

    String defaultValue() default StringUtils.EMPTY;
}
