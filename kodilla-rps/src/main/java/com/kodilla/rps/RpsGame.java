package com.kodilla.rps;

import java.util.Random;

import static com.kodilla.rps.Move.*;

public class RpsGame {
    private String userName;
    private Move userSelection;
    private Move computerSelection;
    private int numberOfPointsToWin;
    private int userPoints;
    private int computerPoints;

    public RpsGame() {
        this.userPoints = 0;
        this.computerPoints = 0;
    }

    private boolean humanWins(Move userSelection, Move computerSelection) {
        if(userSelection == ROCK && computerSelection == SCISSORS){
            return true;
        } else if(userSelection == ROCK && (computerSelection == ROCK || computerSelection == PAPER)){
            return false;
        } else if(userSelection == PAPER && computerSelection == ROCK){
            return true;
        } else if(userSelection == PAPER && (computerSelection == PAPER || computerSelection == SCISSORS)){
            return false;
        } else if(userSelection == SCISSORS && computerSelection == PAPER){
            return true;
        } else {
            return false;
        }
    }

    private boolean computerWins(Move userSelection, Move computerSelection) {
        if(computerSelection == ROCK && userSelection == SCISSORS){
            return true;
        } else if(computerSelection == ROCK && (userSelection == ROCK || userSelection == PAPER)){
            return false;
        } else if(computerSelection == PAPER && userSelection == ROCK){
            return true;
        } else if(computerSelection == PAPER && (userSelection == PAPER || userSelection == SCISSORS)){
            return false;
        } else if(computerSelection == SCISSORS && userSelection == PAPER){
            return true;
        } else {
            return false;
        }
    }

    private Move generateComputerSelection() {
        Random random = new Random();
        int randomInt = random.nextInt(3);
        if(randomInt == 0){
            return ROCK;
        } else if(randomInt == 1){
            return PAPER;
        } else {
            return SCISSORS;
        }
    }

    public void playGame(){
        userName = UserDialogs.getUserName();
        numberOfPointsToWin = UserDialogs.getNumberOfPointsWin();
        System.out.println(userName + " you are playing to " + numberOfPointsToWin + " points.");
        while(userPoints < numberOfPointsToWin && computerPoints < numberOfPointsToWin){
            userSelection = UserDialogs.getUserSelection();
            if(userSelection == NEW_GAME){
                System.out.println("Starting new game.");
                break;
            }
            if(userSelection == END_GAME){
                System.out.println("Thank you for playing!");
                break;
            }
            computerSelection = generateComputerSelection();
            if(computerWins(userSelection, computerSelection)){
                System.out.println("You chose: " + userSelection + ", computer chose: " + computerSelection + ". Computer wins!");
                computerPoints++;
            } else if (humanWins(userSelection, computerSelection)) {
                System.out.println("You chose: " + userSelection + ", computer chose: " + computerSelection + ". You win!");
                userPoints++;
            } else {
                System.out.println("Draw, you both selected " + userSelection + ".");
            }
            System.out.println(userPoints + " - " + userName);
            System.out.println(computerPoints + " - computer");
        }
        if(userPoints == numberOfPointsToWin){
            System.out.println("Congratulations, you won!");
            userSelection = UserDialogs.getUserSelectionAfterEndGame();
        } else if(computerPoints == numberOfPointsToWin) {
            System.out.println("Computer wins this time.");
            userSelection = UserDialogs.getUserSelectionAfterEndGame();
        } else {
            //EMPTY
        }

        if(userSelection == NEW_GAME) {
            userPoints = 0;
            computerPoints = 0;
            playGame();
        }
    }
}
