package com.kodilla.rps;

import static com.kodilla.rps.Move.SCISSORS;

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

    //TODO
    private boolean humanWins(Move userSelection, Move computerSelection) {
        return false;
    }

    //TODO
    private boolean computerWins(Move userSelection, Move computerSelection) {
        return false;
    }

    //TODO
    private Move generateComputerSelection() {
        return SCISSORS;
    }

    public void playGame(){
        userName = UserDialogs.getUserName();
        numberOfPointsToWin = UserDialogs.getNumberOfPointsWin();
        while(userPoints < numberOfPointsToWin && computerPoints < numberOfPointsToWin){
            userSelection = UserDialogs.getUserSelection();
            //TODO
            //IF EXIT OR RESET END
            computerSelection = generateComputerSelection();
            if(computerWins(userSelection, computerSelection)){
                computerPoints++;
            } else if (humanWins(userSelection, computerSelection)) {
                userPoints++;
            } else {
                //TODO
                //SHOW DRAW
            }
            //TODO
            //SHOW STATISTICS
        }
    }
}
