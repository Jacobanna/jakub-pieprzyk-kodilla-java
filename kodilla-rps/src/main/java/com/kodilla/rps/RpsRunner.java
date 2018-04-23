package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args){
        Player player = new Player();
        PlayerDialogs start = new PlayerDialogs();
        start.startGame(player);
    }
}
