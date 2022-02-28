package com.jdai.payslip.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SuperCalculatorTwoTest {
    private SuperCalculatorTwo superCalculatorTwo;

    @BeforeEach
    void setUp() {
        superCalculatorTwo = new SuperCalculatorTwo();
    }

    @Test
    void calculate() {
        int result = superCalculatorTwo.calculate(new BigDecimal(20000), new BigDecimal(0.095));
        assertEquals(0, result);
    }
}