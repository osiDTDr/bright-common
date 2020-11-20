package com.bright.common.validate;

import com.bright.common.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 33356
 * @date 2020/11/09
 */
public class FloatValidator implements ConstraintValidator<FloatData, Float> {
    private int integerDigits;
    private int decimalDigits;

    @Override
    public void initialize(FloatData constraintAnnotation) {
        integerDigits = constraintAnnotation.integerDigits();
        decimalDigits = constraintAnnotation.decimalDigits();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        String valueString = String.valueOf(value);
        int i = NumberUtils.getNumberIntegerDigits(valueString);
        int d = NumberUtils.getNumberDecimalDigits(valueString);
        context.disableDefaultConstraintViolation();
        StringBuilder builder = new StringBuilder();
        if (i > integerDigits) {
            builder.append(String.format("整数位为%d,大于%d", i, integerDigits));
        }
        if (d > decimalDigits) {
            builder.append(String.format("小数位为%d,大于%d", d, decimalDigits));
        }
        if (StringUtils.isNotEmpty(builder)) {
            context.buildConstraintViolationWithTemplate(builder.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
