package com.java.simonsobstaclecourse.model.player;

public class Player {
    String name;
    int playerId;
    int playerPosition;
    public Player(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
        this.playerPosition = 0;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    @Override
    public String toString() {
        return "Player " +  playerId + " : " + name;
    }
}