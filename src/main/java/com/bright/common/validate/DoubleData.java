package com.bright.common.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {DoubleValidator.class}
)
public @interface DoubleData {
    int integerDigits() default 0;

    int decimalDigits() default 0;

    String message() default "Double格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
