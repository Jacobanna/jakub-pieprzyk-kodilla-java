package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public class BookDirectory2 {
    private final List<Book2> theBookList2 = new ArrayList<>();

    public BookDirectory2(){
        theBookList2.add(new Book2("Dylan Murphy", "Wolf of the mountains", 2003, "0001"));
        theBookList2.add(new Book2("Phoebe Pearson", "Slaves of dreams", 2012, "0002"));
        theBookList2.add(new Book2("Morgan Walsh", "Obliteration of heaven", 2001, "0003"));
        theBookList2.add(new Book2("Aimee Murphy", "Rejecting the night", 2015, "0004"));
        theBookList2.add(new Book2("Ryan Talley", "Gangsters and kings", 2007, "0005"));
        theBookList2.add(new Book2("Madelynn Carson", "Unity without duty", 2007, "0006"));
        theBookList2.add(new Book2("Giancarlo Guerrero", "Enemies of eternity", 2009, "0007"));
    }

    public List<Book2> getList() {
        return new ArrayList<>(theBookList2);
    }
}
