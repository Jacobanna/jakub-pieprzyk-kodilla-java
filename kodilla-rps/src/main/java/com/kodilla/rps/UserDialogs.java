package com.kodilla.rps;

import java.util.Scanner;

import static com.kodilla.rps.Move.*;

public class UserDialogs {
    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! You are playing ROCK-PAPER-SCISSORS");
        while (true) {
            System.out.print("Choose your name: ");
            String name = scanner.nextLine();
            if (name.length() < 2 || name.length() > 20) {
                System.out.println("Incorrect name, use 3-20 characters.");
            } else {
                return name;
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

    public static Move getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your move:");
        System.out.println("1.ROCK   2.PAPER   3.SCISSORS");
        System.out.println("X.END GAME   N.NEW GAME");
        String selection;
        while(true){
            selection = scanner.nextLine().toUpperCase();
            switch (selection){
                case "1":   return ROCK;
                case "2":   return PAPER;
                case "3":   return SCISSORS;
                case "X":   return END_GAME;
                case "N":   return NEW_GAME;
                default:    System.out.println(selection + " is not a valid option. Try again.");
                            break;
            }
        }
    }

    public static Move getUserSelectionAfterEndGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play another game?");
        System.out.println("1.YES   2.NO");
        String selection;
        while(true){
            selection = scanner.nextLine();
            switch (selection){
                case "1":   return NEW_GAME;
                case "2":   return END_GAME;
                default:    System.out.println(selection + " is not a valid option. Try again.");
                            break;
            }
        }
    }
}