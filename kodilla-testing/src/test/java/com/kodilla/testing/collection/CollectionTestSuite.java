package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before(){ System.out.println("Collection test: begin"); }
    @After
    public void after() { System.out.println("Collection test: end"); }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> empty = new ArrayList<>();
        ArrayList<Integer> emptyForClass = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> emptyFromClass = oddNumbersExterminator.exterminateOddNumbers(emptyForClass);
        System.out.println("Testing OddNumbersExterminatorEmptyList()");
        //Then
        Assert.assertEquals(empty,emptyFromClass);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> normal = new ArrayList<>();
        ArrayList<Integer> normalListForClass = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        normalListForClass.add(12);
        normalListForClass.add(-3001);
        normalListForClass.add(754);
        normalListForClass.add(333);
        ArrayList<Integer> normalFromClass = oddNumbersExterminator.exterminateOddNumbers(normalListForClass);
        normal.add(12);
        normal.add(754);
        System.out.println("Testing OddNumbersExterminatorNormalList()");
        //Then
        Assert.assertEquals(normal,normalFromClass);
    }
}
