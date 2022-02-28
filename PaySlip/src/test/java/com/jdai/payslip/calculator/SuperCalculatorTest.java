package com.jdai.payslip.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SuperCalculatorTest {
    private SuperCalculator superCalculator;

    @BeforeEach
    void setUp() {
        superCalculator = new SuperCalculator();
    }

    @Test
    public void calculate() {
        int result = superCalculator.calculate(new BigDecimal(20000), new BigDecimal(0.095));
        assertEquals(1900, result);
    }
    @Test
    public void testCalculateWithNullIncome() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    int result = superCalculator.calculate(null, new BigDecimal(0.095));
                    assertEquals(1900, result);
                });
        Assertions.assertEquals("null", thrown.getMessage());
    }

    @Test
    public void testCalculateWithNegIncome() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    int result = superCalculator.calculate(new BigDecimal(-20000), new BigDecimal(0.095));
                    assertEquals(1900, result);
                });
        Assertions.assertEquals("taxableIncome less than zero", thrown.getMessage());
    }

    @Test
    public void testCalculateWithNegSuperRate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    int result = superCalculator.calculate(new BigDecimal(20000), new BigDecimal(-0.095));
                    assertEquals(1900, result);
                });
        Assertions.assertEquals("super rate less than zero", thrown.getMessage());
    }
}