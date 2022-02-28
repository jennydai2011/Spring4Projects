package com.jdai.payslip.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRate {
    private int min;
    private int max;
    private int baseTaxAmount;
    private BigDecimal percentage;
}
