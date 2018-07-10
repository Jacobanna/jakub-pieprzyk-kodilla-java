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
                    setElementFromDb(row, col, val);
                } catch (Exception e) {

                }
            }
        }
    }

    public void setElementFromDb(int col, int row, int val) {
        sudokuRows.get(row).getSudokuElementsFromRow().get(col).setValue(val);
        sudokuRows.get(row).getSudokuElementsFromRow().get(col).setLocked(true);
    }

    public boolean setElementFromUser(int col, int row, int val) {
        if(!sudokuRows.get(row).getSudokuElementsFromRow().get(col).isLocked()) {
            sudokuRows.get(row).getSudokuElementsFromRow().get(col).setValue(val);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String sudokuVisualization ="";
        for(int i = 0; i<=2; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        sudokuVisualization += "- - - + - - - + - - -\n";
        for(int i = 3; i<=5; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        sudokuVisualization += "- - - + - - - + - - -\n";
        for(int i = 6; i<=8; i++) {
            for (int j = 0; j<=2; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 3; j<=5; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "| ";
            for (int j = 6; j<=8; j++) {
                sudokuVisualization += sudokuRows.get(i).getSudokuElementsFromRow().get(j).toString() + " ";
            }
            sudokuVisualization += "\n";
        }
        return sudokuVisualization;
    }
}
