package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public final static int EMPTY = -1;
    private int value;
    private boolean locked;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
            this.value = value;
            this.locked = false;
            for(int i = 1; i < 10; i ++) {
                possibleValues.add(i);
            }
            if(value != EMPTY) {
                possibleValues.remove(new Integer(value));
            }
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
        possibleValues.remove(new Integer(value));
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void removePossibleValue(int value) {
        possibleValues.remove(new Integer(value));
    }

    @Override
    public String toString() {
        if(value != EMPTY) {
            return "" + value;
        } else {
            return " ";
        }
    }
}
