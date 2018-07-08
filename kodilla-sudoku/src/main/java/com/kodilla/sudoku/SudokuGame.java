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
                while(true) {
                    System.out.println(sudokuBoard);
                    chosenMove = UserDialogs.getUserMove();
                    if(chosenMove.equals("EXIT")) {
                        userSelection = END_PROGRAM;
                        break;
                    } else if (chosenMove.equals("SUDOKU")) {
                        //algorithm solving sudoku

                    } else {
                        int col = Integer.parseInt(chosenMove.substring(0,1));
                        int row = Integer.parseInt(chosenMove.substring(2,3));
                        int val = Integer.parseInt(chosenMove.substring(4,5));
                        sudokuBoard.setElement(col,row,val);
                    }
                }
            } else if (userSelection == SANDBOX) {
                sudokuBoard = new SudokuBoard();
                System.out.println(sudokuBoard);
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


}
