package com.kodilla.sudoku;

import java.util.Scanner;

import static com.kodilla.sudoku.Move.*;

public class UserDialogs {
    public static Move getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option:");
        System.out.println("1. START NEW GAME");
        System.out.println("2. SANDBOX");
        System.out.println("3. END PROGRAM");
        int input = 0;
        while(input == 0) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if(input == 1) {
                    return START_GAME;
                } else if (input == 2) {
                    return SANDBOX;
                } else if (input == 3) {
                    return END_PROGRAM;
                } else {
                    System.out.println("Option unavailable, try again.");
                    input = 0;
                }

            } catch(Exception e) {
                System.out.println("Option unavailable, try again.");
//                input = 0;
//                This line is not required, exception occurs so input value is not overwritten.
            }
        }
        return ERROR;
    }

    public static String getUserMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Choose number in format column,row,value (e.g. 2,4,6) - values from 1 to 9.");
        System.out.println("2. Write SUDOKU to solve current game");
        System.out.println("3. Write EXIT to end program");

        while(true) {
            String input = scanner.nextLine().toUpperCase();
            if (isCorrectMove(input)) {
                return input;
            } else {
                System.out.println("Make sure you wrote down column,row,value (e.g. 2,4,6), SUDOKU or EXIT. Try again.");
            }
        }
    }

    public static boolean isCorrectMove(String string) {
        if(string.equals("SUDOKU")) {
            return true;
        } else if (string.equals("EXIT")) {
            return true;
        } else if (isSelectionCorrect(string)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSelectionCorrect(String string) {
        if(string.length() == 5) {
            char firstChar = string.charAt(0);
            char secondChar = string.charAt(1);
            char thirdChar = string.charAt(2);
            char fourthChar = string.charAt(3);
            char fifthChar = string.charAt(4);
            if( Character.isDigit(firstChar) && firstChar != '0' &&
                secondChar == ',' &&
                Character.isDigit(thirdChar) && thirdChar != '0' &&
                fourthChar == ',' &&
                Character.isDigit(fifthChar) && fifthChar != '0') {
                return true;
            }
        }
        return false;
    }
}
