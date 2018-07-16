package com.kodilla.sudoku;

public class SudokuBoardCopy {
    private SudokuBoard sudokuBoard;
    private int col;
    private int row;
    private Integer guessedValue;

    public SudokuBoardCopy(SudokuBoard sudokuBoard, int col, int row, Integer guessedValue) {
        this.sudokuBoard = sudokuBoard;
        this.col = col;
        this.row = row;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Integer getGuessedValue() {
        return guessedValue;
    }
}
