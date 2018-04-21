package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor(){
        //Given
        BookDirectory2 bookDirectory2 = new BookDirectory2();
        //When
        List<Book2> book2List = bookDirectory2.getList();
        //Then
        int numberOfBooksPublishedAfter2007 = 0;
        for(Book2 book2 : book2List){
            if(book2.getYearOfPublication() > 2007){
                numberOfBooksPublishedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublishedAfter2007);
    }

    @Test
    public void testGetListUsingIntStream(){
        //Given
        BookDirectory2 bookDirectory2 = new BookDirectory2();
        //When
        List<Book2> book2List = bookDirectory2.getList();
        //Then
//        int numberOfBookPublishedAfter2007 = IntStream.range(0,book2List.size())
//                .filter(n -> book2List.get(n).getYearOfPublication() > 2007)
//                .map(n -> 1)
//                .sum();
//        Assert.assertEquals(3,numberOfBookPublishedAfter2007);

        long numberOfBookPublishedAfter2007 = IntStream.range(0,book2List.size())
                .filter(n -> book2List.get(n).getYearOfPublication() > 2007)
                .count();
        Assert.assertEquals(3,numberOfBookPublishedAfter2007);

    }
}
