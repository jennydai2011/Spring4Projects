package com.jdai.payslip.model;

import lombok.Data;

@Data
public class Payslip {
    private String name;
    private DatePeriod payPeriod;
    private int grossIncome;
    private int incomeTax;
    private int netIncome;
    private int superAmount;

    public String export(){
        //format data
        return null;
    }
}
