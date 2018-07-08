package com.kodilla.sudoku;

public class SudokuElement {
    public final static int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
