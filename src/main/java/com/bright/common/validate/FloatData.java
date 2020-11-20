package com.bright.common.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {FloatValidator.class}
)
public @interface FloatData {
    int integerDigits() default 0;

    int decimalDigits() default 0;

    String message() default "Float格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
