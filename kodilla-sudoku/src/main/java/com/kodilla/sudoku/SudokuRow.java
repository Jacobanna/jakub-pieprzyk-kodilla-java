package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements = new ArrayList<>();

    public SudokuRow() {
        for(int n = 0; n < 9; n++) {
            sudokuElements.add(new SudokuElement(SudokuElement.EMPTY));
        }
    }

    public List<SudokuElement> getSudokuElementsFromRow() {
        return sudokuElements;
    }

    public void setSudokuElements(List<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }
}
