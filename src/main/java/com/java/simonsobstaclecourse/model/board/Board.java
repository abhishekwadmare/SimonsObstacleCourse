package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.player.Players;

public class Board {
    private Squares squares;
    private Players players;
    private Dice dice;
    private boolean gameOver;

    public Board(Dice dice, Players players){
        this.dice = dice;
        this.players = players;

        gameOver = false;
        squares = new Squares(25);
    }

    public Squares getSquares() {
        return squares;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void move(Boolean moveChoice){
        if(!moveChoice)
            return;
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());
        if(isValidMove()){
            currentSquare.removePlayer();
            destinationSquare.setPlayer(players.getCurrentPlayer());
            players.getCurrentPlayer().setPlayerPosition(destinationSquare.squareId);
        }
    }

    public Boolean isValidMove(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());

        if(currentSquare.obstacle == null) {
            //check if future square is occupied
            if(destinationSquare.getPlayer() != null){
                return false;
            }
        }

        return true;
    }

}
