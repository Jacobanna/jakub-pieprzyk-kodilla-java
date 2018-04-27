package com.kodilla.rps;

import java.util.Scanner;

import static com.kodilla.rps.Move.ROCK;

public class UserDialogs {
    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome! You are playing ROCK-PAPER-SCISSORS");
            System.out.print("Choose your name: ");
            String s = scanner.nextLine();
            if (s.length() < 2 && s.length() > 20) {
                System.out.println("Incorrect name, use 3-20 characters.");
            } else {
                return s;
            }
        }
    }

    //TODO
    public static int getNumberOfPointsWin() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPointsToWin;
        String input = null;
        while (input == null) {
            System.out.print("Choose how much points to win the game (1-10): ");
            input = scanner.nextLine();
            try {
                numberOfPointsToWin = Integer.valueOf(input);
                if (numberOfPointsToWin > 0 && numberOfPointsToWin <= 10) {
                    return numberOfPointsToWin;
                } else {
                    System.out.println("Expected number value between 1-10, not: '" + input + "'. Try again.");
                    input = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Expected number value between 1-10, not: '" + input + "'. Try again.");
                input = null;
            }
        }
        //SHOULD NEVER HAPPEN
        return -1;
    }

    //TODO
    public static Move getUserSelection() {
        return ROCK;
    }
}
//
//    public int startGame(User user){
//        System.out.println("Welcome! You are playing ROCK-PAPER-SCISSORS");
//        System.out.print("Choose your name: ");
//        user.setName();
//        int numberOfPointsToWin;
//        String input = null;
//        while(input == null) {
//            System.out.print("Choose how much points to win the game (1-10): ");
//            input = user..nextLine();
//            try {
//                numberOfPointsToWin = Integer.valueOf(input);
//                if (numberOfPointsToWin > 0 && numberOfPointsToWin <= 10) {
//                    return numberOfPointsToWin;
//                } else {
//                    System.out.println("Expected number value between 1-10, not: '" + input + "'. Try again.");
//                    input = null;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Expected number value between 1-10, not: '" + input + "'. Try again.");
//                input = null;
//            }
//        }
//        //Should never happen
//        return input;
//    }
//
//
//        System.out.println(user.getName() + " you are playing to " + numberOfPointsToWin + " points vs computer.");
//        System.out.println("Choose your move using keyboard:");
//        System.out.println("1. ROCK");
//        System.out.println("2. PAPER");
//        System.out.println("3. SCISSORS");
//        System.out.println("X. END GAME");
//        System.out.println("N. NEW GAME");
//    }
