package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void testMedianAdapter() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Book book1 = new Book("Whitney G", "Two Weeks Notice", 2008, "500/3");
        Book book2 = new Book("Mike Omer", "A Killer's Mind", 2013, "500/4");
        Book book3 = new Book("Margaret Wise Brown", "Goodnight Moon", 2000, "500/7");
        Book book4 = new Book("Omarosa Newman", "Unhinged", 2018, "500/1");
        Book book5 = new Book("James Peterson", "Texas Ranger", 1995, "500/12");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2008, median);
    }
}
