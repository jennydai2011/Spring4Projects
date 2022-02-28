package com.jdai.payslip.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class NonNegativeValidator implements ConstraintValidator<BigDecimal, String>{

//    public void validate(BigDecimal data){
//        if(data == null){
//            throw new IllegalArgumentException("Input data cannot be null");
//        }
//        if (data.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException(String.format("Input data %s cannot less than 0", data));
//        }
//    }
}
