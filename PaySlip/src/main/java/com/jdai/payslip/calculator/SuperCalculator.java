package com.jdai.payslip.calculator;

import java.math.BigDecimal;

public class SuperCalculator {
    private final PositiveValidator positiveValidator = new PositiveValidator();

    public int calculate(BigDecimal taxableIncome, BigDecimal superRate){
        validate(taxableIncome, superRate);
        return taxableIncome.multiply(superRate).toBigInteger().intValue();
    }

    private void validate(BigDecimal taxableIncome, BigDecimal superRate) {
        positiveValidator.validatePositive(taxableIncome, "taxableIncome less than zero");
        positiveValidator.validatePositive(superRate, "super rate less than zero");
    }

    private void validatePositive(BigDecimal taxableIncome, String less_than_zero) {
        positiveValidator.validatePositive(taxableIncome, less_than_zero);
    }

}
