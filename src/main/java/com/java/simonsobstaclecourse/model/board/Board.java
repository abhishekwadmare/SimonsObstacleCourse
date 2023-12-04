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

    public boolean isGameWon(){
        return players.getCurrentPlayer().getPlayerPosition() == squares.size() - 1;
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
            if(destinationSquare.obstacle !=null)
                destinationSquare.obstacle.applyEffect(players.getCurrentPlayer(), squares);
        }
    }

    public Boolean isValidMove(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);

        if(currentPlayerPosition + dice.getDiceValue() > squares.size()-1){
            return false;
        }

        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());

        //check if future square is occupied
        if(destinationSquare.getPlayer() != null){
            return false;
        }
        if(currentSquare.obstacle != null) {
            //player is in fire pit
            if(players.getCurrentPlayer().isSkipTurn()){
                players.getCurrentPlayer().setSkipTurn(false);
                return false;
            } else if(dice.getDiceValue() < players.getCurrentPlayer().getRequiredMove()){
                //player is in spike pit
                return false;
            }

            //if valid move reset the required moves for the current player
            if(dice.getDiceValue() >= players.getCurrentPlayer().getRequiredMove()){
                players.getCurrentPlayer().setRequiredMove(0);
            }
        }
        return true;
    }
}
