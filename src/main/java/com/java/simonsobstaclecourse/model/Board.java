package com.java.simonsobstaclecourse.model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;
    private ArrayList<Player> players;
    private Dice dice;
    private boolean gameOver;

    public Board(ArrayList<Player> players){
        gameOver = false;
        this.players = players;
        dice = new Dice();
        setupSquares();
    }

    public void rollDice(){
        //roll the dice
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private void setupSquares(){

    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }


}
