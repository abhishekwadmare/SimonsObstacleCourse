package com.java.simonsobstaclecourse.model.player;

public class Player {
    String name;
    int playerId;
    int playerPosition;
    int requiredMove = 0;
    boolean skipTurn = false;



    public Player(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
        this.playerPosition = 0;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }
    public int getPlayerId() {
        return playerId;
    }

    public int getRequiredMove() {
        return requiredMove;
    }

    public void setRequiredMove(int requiredMove) {
        this.requiredMove = requiredMove;
    }

    public boolean isSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    @Override
    public String toString() {
        return "Player " +  playerId + " : " + name;
    }
}