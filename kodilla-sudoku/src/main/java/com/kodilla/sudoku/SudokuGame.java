package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.sudoku.Move.*;

@SuppressWarnings("Duplicates")
public class SudokuGame {
    private Move userSelection;
    private String chosenMove;
    private SudokuBoard sudokuBoard;
    private List<SudokuBoardCopy> sudokuBoardCopies = new ArrayList<>();

    public void playGame() {
        while (true) {
            System.out.println("___SUDOKU___");
            userSelection = UserDialogs.getUserSelection();

            if (userSelection == START_GAME) {
                sudokuBoard = new SudokuBoard();
                sudokuBoard.fillFromString(SudokuRepository.getSpecificSudoku());
//                newGame();
                gameMechanics();
            } else if (userSelection == SANDBOX) {
                sudokuBoard = new SudokuBoard();
                gameMechanics();
            } else if (userSelection == END_PROGRAM) {
                System.out.println("Thanks for playing.");
                break;
            } else {
                //Should never happen
                System.out.println("ERROR");
            }
            if (userSelection == END_PROGRAM) {
                break;
            }
        }
    }

    public void gameMechanics() {
        boolean isCorrectData = true;
        while (true) {
            System.out.println(sudokuBoard);
            if (sudokuBoard.isSudokuSolved()) {
                System.out.println("Congratulations, sudoku solved!");
                UserDialogs.waitForInput();
                break;
            }
            if (!isCorrectData) {
                UserDialogs.waitForInput();
                break;
            }
            chosenMove = UserDialogs.getUserMove();
            if (chosenMove.equals("EXIT")) {
                userSelection = END_PROGRAM;
                break;
            } else if (chosenMove.equals("SUDOKU")) {
                boolean solved = solveSudoku(sudokuBoard);
                if (!solved) {
                    isCorrectData = false;
                    System.out.println("Data for sudoku is incorrect. Try different sudoku.");
                }

            } else if (UserDialogs.isSelectionCorrect(chosenMove)) {
                int col = Integer.parseInt(chosenMove.substring(0, 1)) - 1;
                int row = Integer.parseInt(chosenMove.substring(2, 3)) - 1;
                int val = Integer.parseInt(chosenMove.substring(4, 5));
                int temp = sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getValue();
                if (sudokuBoard.setElementFromUser(col, row, val)) {
                    sudokuBoard.setElementFromUser(col, row, temp);
                    if (isAllowedMove(col, row, val)) {
                        sudokuBoard.setElementFromUser(col, row, val);
                        System.out.println("Successfully changed field.");
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

    public void newGame() {
        sudokuBoard.fillFromString(SudokuRepository.getRandomSudoku());
    }

    public boolean isAllowedMove(int col, int row, int val) {

        List<SudokuElement> sudokuElementsFromRow = new ArrayList<>();
        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow()) {
            sudokuElementsFromRow.add(sudokuElement);
        }
        for (SudokuElement sudokuElement : sudokuElementsFromRow) {
            if (val == sudokuElement.getValue()) {
                return false;
            }
        }

        List<SudokuElement> sudokuElementsFromCol = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuElementsFromCol.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(col));
        }
        for (SudokuElement sudokuElement : sudokuElementsFromCol) {
            if (val == sudokuElement.getValue()) {
                return false;
            }
        }

        List<SudokuElement> sudokuElementsFrom3X3 = new ArrayList<>();
        if ((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(0));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(1));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(2));
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(3));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(4));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(5));
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(6));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(7));
                sudokuElementsFrom3X3.add(sudokuBoard.getSudokuRows().get(i).getSudokuElementsFromRow().get(8));
            }
        }
        for (SudokuElement sudokuElement : sudokuElementsFrom3X3) {
            if (val == sudokuElement.getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean solveSudoku(SudokuBoard sudokuBoard) {
        int counter;
        boolean solved = false;
        boolean atLeastOneSolved = true;
        while (true) {
            if (sudokuBoard.isSudokuSolved()) {
                return true;
            }
            while (atLeastOneSolved) {
                atLeastOneSolved = false;
                counter = 0;
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        //1
                        if (sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getValue() == -1) {
                            removePossibleValues(col, row, sudokuBoard);
                            if (sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getPossibleValues().size() == 1) {
                                sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).setValue(sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getPossibleValues().get(0));
                                atLeastOneSolved = true;
                                counter++;
                                continue;
                            }
                        }
                        //2
                        List<Integer> usedValues = getPossibleValues(col, row, sudokuBoard);
                        for (Integer possibleValue : sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getPossibleValues()) {
                            if (!usedValues.contains(possibleValue)) {
                                sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).setValue(possibleValue);
                                atLeastOneSolved = true;
                                counter++;
                                continue;
                            }
                        }
                    }
                }
                if (counter == 0) {
                    if (!sudokuBoard.isSudokuSolved()) {
                        try {
                            for (int row = 0; row < 9; row++) {
                                for (int col = 0; col < 9; col++) {
                                    if (sudokuBoard.getValueAt(col, row) == -1) {
                                        for (int pos = 0; pos < sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getPossibleValues().size(); pos++) {
                                            Integer value = sudokuBoard.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).getPossibleValues().get(pos);
                                            atLeastOneSolved = true;
                                            SudokuBoard sudokuCopy = sudokuBoard.deepCopy();
                                            sudokuCopy.getSudokuRows().get(row).getSudokuElementsFromRow().get(col).setValue(value);
                                            if(solveSudoku(sudokuCopy)) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                            return false;
                        } catch (CloneNotSupportedException e) {
                            System.out.println("Clone not supported exception.");
                        }
                    }
                }
            }
            // Solved
            if (sudokuBoard.isSudokuSolved()) {
                return true;
            }
            // Not solved, not available possible values
            else {
                return false;
            }
        }
    }

    private void removePossibleValues(int col, int row, SudokuBoard sudokuBoard) {
        //ROW
        for (int n = 0; n < 9; n++) {
            Integer val = sudokuBoard.getValueAt(n, row);
            if (val != -1) {
                sudokuBoard.removeValueFromPossibleAt(col, row, val);
            }
        }

        //COL
        for (int n = 0; n < 9; n++) {
            Integer val = sudokuBoard.getValueAt(col, n);
            if (val != -1) {
                sudokuBoard.removeValueFromPossibleAt(col, row, val);
            }
        }

        //3X3
        if ((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    Integer val = sudokuBoard.getValueAt(j, i);
                    if (val != -1) {
                        sudokuBoard.removeValueFromPossibleAt(col, row, val);
                    }
                }
            }
        }
    }

    private List<Integer> getPossibleValues(int col, int row, SudokuBoard sudokuBoard) {
        List<Integer> usedValues = new ArrayList<>();
        //ROW
        for (int i = 0; i < 9; i++) {
            if (i != col) {
                usedValues.add(sudokuBoard.getValueAt(i, row));
                for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(i, row)) {
                    usedValues.add(possibleValueFromOtherField);
                }
            }
        }
        //COL
        for (int i = 0; i < 9; i++) {
            if (i != row) {
                usedValues.add(sudokuBoard.getValueAt(col, i));
                for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(col, i)) {
                    usedValues.add(possibleValueFromOtherField);
                }
            }
        }
        //3X3
        if ((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 0 || row == 1 || row == 2)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 3 || row == 4 || row == 5)) {
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 0 || col == 1 || col == 2) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 3 || col == 4 || col == 5) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        } else if ((col == 6 || col == 7 || col == 8) && (row == 6 || row == 7 || row == 8)) {
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    usedValues.add(sudokuBoard.getValueAt(j, i));
                    for (Integer possibleValueFromOtherField : sudokuBoard.getPossibleValuesAt(j, i)) {
                        usedValues.add(possibleValueFromOtherField);
                    }
                }
            }
        }
        return usedValues;
    }

    private List<Integer> getPossibleValuesFromBoard() {
        List<Integer> possibleValues = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                for (Integer possibleValue : sudokuBoard.getPossibleValuesAt(col, row)) {
                    possibleValues.add(possibleValue);
                }
            }
        }
        return possibleValues;
    }
}