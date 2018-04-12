package com.kodilla.testing.calculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTestSuite {
    @Before
    public void before(){ System.out.println("Collection test: begin"); }
    @After
    public void after() { System.out.println("Collection test: end"); }
    @Test
    public void testAdd(){
        //Given
        Calculator calculator = new Calculator();
        int expectedResult = 8;
        //When
        int result = calculator.add(5,3);
        System.out.println("Testing add()");
        //Then
        Assert.assertEquals(expectedResult, result);
    }
    @Test
    public void testSubtract(){
        //Given
        Calculator calculator = new Calculator();
        int expectedResult = 3;
        //When
        int result = calculator.subtract(8,5);
        System.out.println("Testing subtract()");
        //Then
        Assert.assertEquals(expectedResult,result);
    }
}
