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
                if(isAllowedMove(col,row,val) && sudokuBoard.setElementFromUser(col,row,val)) {
                    System.out.println("Succesfully changed field.");
                } else {
                    System.out.println("Cannot change this field - it's part of starting data set.");
                }
            } else {
                //Should never happen
                System.out.println("ERROR");
            }
        }
    }

    public boolean isAllowedMove(int col, int row, int val) {
        int counter = 0;

        List<SudokuElement> sudokuElementsFromRow = new ArrayList<>();
        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow()) {
            sudokuElementsFromRow.add(sudokuElement);
        }
        for (SudokuElement sudokuElement : sudokuElementsFromRow) {
            System.out.println("From row: " + sudokuElement.getValue());
            if(val == sudokuElement.getValue()) {
                counter++;
            }
        }

        List<SudokuElement> sudokuElementsFromCol = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            sudokuElementsFromCol.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(col));
        }
        for (SudokuElement sudokuElement : sudokuElementsFromCol) {
            System.out.println("From col: " + sudokuElement.getValue());
            if(val == sudokuElement.getValue()) {
                counter++;
            }
        }

        //TODO
        //Need one more check - for field 3X3

        if(counter == 0) {
            return true;
        } else {
            return false;
        }
    }
}
