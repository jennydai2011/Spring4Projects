package com.jdai.payslip.calculator;

import java.math.BigDecimal;

public class TaxCalculator {
    public int calculate(BigDecimal grossIncome, BigDecimal taxRate){
        return grossIncome.multiply(taxRate).toBigInteger().intValue();
    }
}
