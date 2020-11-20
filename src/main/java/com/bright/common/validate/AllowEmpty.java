package com.bright.common.validate;

import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zhengyuan
 * @since 2020/11/20
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {AllowEmptyValidator.class}
)
public @interface AllowEmpty {
    boolean allow() default true;

    String message() default StringUtils.EMPTY;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
