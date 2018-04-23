package com.kodilla.rps;

public class PlayerDialogs {
    void startGame(Player player){
        System.out.println("Welcome! You are playing ROCK-PAPER-SCISSORS");
        System.out.println("Choose your name:");
        player.chooseName();
        System.out.println("Choose how much points to win the game (1-10):");
        int numberOfPointsToWin = player.chooseNumberOfPointsToWin();
        System.out.println(numberOfPointsToWin);

    }
}
