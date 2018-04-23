package com.kodilla.rps;

import java.util.Scanner;

public class Player implements Moveable {
    private Scanner scanner;
    private String name;

    public Player() {
        this.scanner = new Scanner(System.in);
    }

    public void chooseName(){
        name = scanner.next();
    }

    public int chooseNumberOfPointsToWin(){
        int numberOfPointsToWin;
        String line = null;
        while(line == null){
            line = scanner.nextLine();
        }
        try{
            numberOfPointsToWin = Integer.valueOf(line);
            if(numberOfPointsToWin > 0 && numberOfPointsToWin <=10){
                return numberOfPointsToWin;
            }
        } catch (NumberFormatException e){
            System.out.println("Expected number value between 1-10, not: '" + line + "'. Try again.\n");
            line = null;
        }

        return -1;
    }

    @Override
    public Move getMove() {
        //TODO
        return null;
    }
}
