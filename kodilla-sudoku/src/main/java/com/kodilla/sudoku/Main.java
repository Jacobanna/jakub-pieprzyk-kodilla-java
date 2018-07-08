package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        SudokuElement sudokuElement = new SudokuElement(5);
//
//        List<SudokuElement> sudokuElements = new ArrayList<>();
//        for(int i=0; i<9; i++) {
//            sudokuElements.add(i,sudokuElement);
//        }
//        SudokuRow sudokuRow = new SudokuRow(sudokuElements);
//
//        List<SudokuRow> sudokuRows = new ArrayList<>();
//        for(int i=0; i<9; i++) {
//            sudokuRows.add(i,sudokuRow);
//        }
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillFromString(SudokuRepository.getSudokus().get(0));
        System.out.println(sudokuBoard.toString());
    }
}
