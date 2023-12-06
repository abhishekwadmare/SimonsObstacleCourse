package com.java.simonsobstaclecourse.model.board;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

public class Board {
    private Squares squares;
    private Players players;
    private Dice dice;

    private ScoreBoard scoreBoard;
    private boolean gameOver;

    public Board(Dice dice, Players players){
        this.dice = dice;
        this.players = players;
        gameOver = false;
        squares = new Squares(25);
        scoreBoard = new ScoreBoard();
    }

    public Squares getSquares() {
        return squares;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getCurrentPlayerObstacleId(int diceValue){
        return squares.get(players.getCurrentPlayer().getPlayerPosition() + diceValue).getObstacleId();
    }

    public boolean isGameWon(){
        return players.getCurrentPlayer().getPlayerPosition() == squares.size() - 1;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void move(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());
        currentSquare.removePlayer();
        destinationSquare.setPlayer(players.getCurrentPlayer());
        players.getCurrentPlayer().setPlayerPosition(destinationSquare.squareId);
    }

    public void handelObstacle(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());
        switch (destinationSquare.getObstacleId()){
            case 0:
                move();
                break;
            case 1:
                destinationSquare.obstacle.applyEffect(players, squares);
                break;
            case 2,3,4:
                destinationSquare.obstacle.applyEffect(players,squares);
                move();
                break;
        }
    }


    public Boolean isValidMove(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);

        if(currentPlayerPosition + dice.getDiceValue() > squares.size()-1){
            return false;
        }

        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());

        //check if destination square is occupied
        if(destinationSquare.getPlayer() != null){
            return false;
        }

        if(currentSquare.obstacle != null) {
            //player is in fire pit
            if(players.getCurrentPlayer().isSkipTurn()){
                players.getCurrentPlayer().setSkipTurn(false);
                return false;
            }
            //player is in spike pit
            if(dice.getDiceValue() < players.getCurrentPlayer().getRequiredMove()){
                return false;
            } else {
                //if valid move reset the required moves for the current player
                players.getCurrentPlayer().setRequiredMove(0);
            }
        }
        return true;
    }
}
