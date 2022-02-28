package com.jdai.payslip.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class DatePeriod {
    private LocalDate startDate;
    private LocalDate endDate;

    public DatePeriod(String datePeriod) {
        //parse String to get startDate and enddate
    }

    public String payslipOutput(DateTimeFormatter formatter) {
        return String.format("%s-%s", startDate.format(formatter), endDate.format(formatter));
    }
}
