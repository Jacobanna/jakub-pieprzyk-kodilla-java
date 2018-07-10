package com.kodilla.sudoku;

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
                if(sudokuBoard.setElementFromUser(col,row,val)) {
                    System.out.println("Succesfully changed field.");
                } else {
                    System.out.println("Cannot change this field - it's part of start data.");
                }
            } else {
                //Should never happen
                System.out.println("ERROR");
            }
        }
    }


}
