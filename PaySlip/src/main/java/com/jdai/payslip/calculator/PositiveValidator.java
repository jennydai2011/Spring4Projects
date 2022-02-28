package com.jdai.payslip.calculator;

import java.math.BigDecimal;

public class PositiveValidator {
    public PositiveValidator() {
    }

    void validatePositive(BigDecimal taxableIncome, String less_than_zero) {
        if(taxableIncome == null){
            throw new IllegalArgumentException("null");
        }
        if (taxableIncome.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(less_than_zero);
        }
    }
}