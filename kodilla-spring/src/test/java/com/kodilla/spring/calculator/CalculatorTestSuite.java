package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        Double addition = calculator.add(5.3,3.3);
        Double subtraction = calculator.subtract(5.3,3.3);
        Double multiplification = calculator.multiply(5.5,3);
        Double division = calculator.divide(6,4);
        //Then
        Assert.assertEquals(8.6,addition,0.0001);
        Assert.assertEquals(2,subtraction,0.0001);
        Assert.assertEquals(16.5,multiplification,0.0001);
        Assert.assertEquals(1.5,division,0.0001);
    }
}
