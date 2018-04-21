package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] elements = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        //When
        double result = ArrayOperations.getAverage(elements);
        double expectedResult = 10.5;
        //Then
        Assert.assertEquals(expectedResult,result,0.001);
    }
}
