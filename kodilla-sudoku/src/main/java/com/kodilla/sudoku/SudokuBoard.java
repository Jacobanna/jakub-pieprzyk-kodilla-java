package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for(int n = 0; n < 9; n++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public void fillFromString(String sudoku) {
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {
                try {
                    int val = Integer.parseInt(sudoku.substring(row*9 + col, row*9 + col+1));
                    setElement(row, col, val);
                } catch (Exception e) {

                }
            }
        }
    }

    private void setElement(int row, int col, int val) {
        sudokuRows.get(row).getSudokuElements().get(col).setValue(val);
    }

    @Override
    public String toString() {
        String sudokuVisualization ="";
        for(int i = 0; i<=2; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        sudokuVisualization += "- - - + - - - + - - -\n";
        for(int i = 3; i<=5; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        sudokuVisualization += "- - - + - - - + - - -\n";
        for(int i = 6; i<=8; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElements().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        return sudokuVisualization;
    }
}
