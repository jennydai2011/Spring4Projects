package com.jdai.payslip.model;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Employee {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private BigDecimal grossIncome;

    private BigDecimal superRate;
}
