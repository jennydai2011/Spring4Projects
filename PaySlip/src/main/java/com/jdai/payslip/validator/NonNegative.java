package com.jdai.payslip.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.math.BigDecimal;

/**
 * @author jenny
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={NonNegativeValidatorAnnotation.class})
public @interface NonNegative {
    String message() default "Value cannot be less than 0";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
