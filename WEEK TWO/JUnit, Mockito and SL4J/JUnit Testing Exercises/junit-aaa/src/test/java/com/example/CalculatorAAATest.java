package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }

    @Test
    public void testAddition() {

        int a = 10;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {

        int a = 8;
        int b = 3;
        int result = calculator.subtract(a, b);
        assertEquals(5, result);
    }
}
