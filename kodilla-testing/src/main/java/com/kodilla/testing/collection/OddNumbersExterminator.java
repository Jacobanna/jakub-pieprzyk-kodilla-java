package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminateOddNumbers(ArrayList<Integer> numbers){
        ArrayList<Integer> evenNumbersOnly = new ArrayList<>();
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)%2 == 0){
                evenNumbersOnly.add(numbers.get(i));
            }
        }
        return evenNumbersOnly;
    }
}
