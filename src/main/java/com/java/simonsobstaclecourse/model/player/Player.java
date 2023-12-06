package com.java.simonsobstaclecourse.model.player;

public class Player {
    String name;

    int score;
    int playerId;
    int playerPosition;
    int requiredMove;

    boolean skipTurn = false;

    public Player(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
    }

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
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

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
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