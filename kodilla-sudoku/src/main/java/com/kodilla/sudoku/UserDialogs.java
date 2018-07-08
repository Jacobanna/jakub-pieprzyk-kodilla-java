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
        System.out.println("1. Choose number in format column,row,value (e.g. 2,4,6)");
        System.out.println("2. Write SUDOKU to solve current game");
        System.out.println("3. Write EXIT to end program");
        String input = scanner.nextLine().toUpperCase();

        //TODO
        //input == "2,4,6" is placeholder, need function to check all possible arguments
        if (input == "2,4,6" || input == "SUDOKU" || input == "EXIT") {
            return input;
        } else {
            System.out.println("Option not available. Try again.");
        }

        return input;
    }
}
