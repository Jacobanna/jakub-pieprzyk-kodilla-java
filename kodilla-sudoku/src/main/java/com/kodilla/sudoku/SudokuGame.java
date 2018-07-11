package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.sudoku.Move.*;

public class SudokuGame {
    private Move userSelection;
    private String chosenMove;
    private SudokuBoard sudokuBoard = new SudokuBoard();

    public void playGame() {
        while(true) {
            System.out.println("___SUDOKU___");
            userSelection = UserDialogs.getUserSelection();

            if(userSelection == START_GAME) {
                newGame();
                gameMechanics();
            } else if (userSelection == SANDBOX) {
                sudokuBoard = new SudokuBoard();
                gameMechanics();
            } else if (userSelection == END_PROGRAM){
                System.out.println("Thanks for playing.");
                break;
            } else {
                //Should never happen
                System.out.println("ERROR");
            }

            if(userSelection == END_PROGRAM) {
                break;
            }
        }
    }

    public void newGame() {
        sudokuBoard.fillFromString(SudokuRepository.getRandomSudoku());
    }

    public void gameMechanics() {
        while(true) {
            System.out.println(sudokuBoard);
            chosenMove = UserDialogs.getUserMove();
            if(chosenMove.equals("EXIT")) {
                userSelection = END_PROGRAM;
                break;
            } else if (chosenMove.equals("SUDOKU")) {
                //algorithm solving sudoku

            } else if (UserDialogs.isSelectionCorrect(chosenMove)) {
                int col = Integer.parseInt(chosenMove.substring(0,1)) - 1;
                int row = Integer.parseInt(chosenMove.substring(2,3)) - 1;
                int val = Integer.parseInt(chosenMove.substring(4,5));
                int temp = sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getValue();
                if(sudokuBoard.setElementFromUser(col,row,val)) {
                    sudokuBoard.setElementFromUser(col,row,temp);
                    if(isAllowedMove(col,row,val)) {
                        sudokuBoard.setElementFromUser(col,row,val);
                        System.out.println("Succesfully changed field.");
                    } else {
                        System.out.println("Try again - this number is already in the same column, row or 3X3 field.");
                    }
                } else {
                    System.out.println("Try again - cannot change this field - it's part of starting data set.");
                }
            } else {
                //Should never happen
                System.out.println("ERROR");
            }
        }
    }

    public boolean isAllowedMove(int col, int row, int val) {

        List<SudokuElement> sudokuElementsFromRow = new ArrayList<>();
        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow()) {
            sudokuElementsFromRow.add(sudokuElement);
        }
        for (SudokuElement sudokuElement : sudokuElementsFromRow) {
            System.out.println("From row: " + sudokuElement.getValue());
            if(val == sudokuElement.getValue()) {
                return false;
            }
        }

        List<SudokuElement> sudokuElementsFromCol = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            sudokuElementsFromCol.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(col));
        }
        for (SudokuElement sudokuElement : sudokuElementsFromCol) {
            System.out.println("From col: " + sudokuElement.getValue());
            if(val == sudokuElement.getValue()) {
                return false;
            }
        }

        List<SudokuElement> sudokuElementsFrom3X3 = new ArrayList<>();
        if((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if((col == 3 || col == 4 || col == 5) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if((col == 6 || col == 7 || col == 8) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        } else if((col == 0 || col == 1 || col == 2) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if((col == 3 || col == 4 || col == 5) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if((col == 6 || col == 7 || col == 8) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        } else if((col == 0 || col == 1 || col == 2) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if((col == 3 || col == 4 || col == 5) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if((col == 6 || col == 7 || col == 8) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9 ; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        }
        for (SudokuElement sudokuElement : sudokuElementsFrom3X3) {
            if(val == sudokuElement.getValue()) {
                return false;
            }
        }
        return true;
    }
}