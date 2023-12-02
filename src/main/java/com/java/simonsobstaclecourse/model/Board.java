package com.java.simonsobstaclecourse.model;

import java.util.ArrayList;

public class Board {
//    private ArrayList<Square> squares;
    private Squares squares;
    private ArrayList<Player> playerList;
    private Dice dice;
    private boolean gameOver;

    public Board(ArrayList<Player> playerList){
        gameOver = false;
        this.playerList = playerList;
        dice = new Dice();
        squares = new Squares(25);
    }

    public void rollDice(){
        dice.roll();
    }

    public Squares getSquares() {
        return squares;
    }

    public int getDice() {
        return dice.getDiceValue();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ArrayList<Player> getPlayers() {
        return playerList;
    }

}
