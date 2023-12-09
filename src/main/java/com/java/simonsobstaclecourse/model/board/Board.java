package com.java.simonsobstaclecourse.model.board;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

/**
 * Represents the game board for Simon's Obstacle Course.
 * This manages player movements, obstacles, and game state.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 */
public class Board {

    // Attributes

    /** Collection of squares on the game board. */
    private Squares squares;
    private int difficulty = 1;

    /** Player information and management. */
    private Players players;

    /** Dice for generating random values during the game. */
    private Dice dice;

    private ScoreBoard scoreBoard;

    /** Flag indicating whether the game is over. */
    private boolean gameOver;

    // Constructor

    /**
     * Constructs a Board with the specified dice and players.
     *
     * @param dice    The dice used in the game.
     * @param players The collection of players in the game.
     */
    public Board(Dice dice, Players players, int difficulty, int boardSize){
        this.dice = dice;
        this.players = players;

        // Initializing game state
        gameOver = false;
        squares = new Squares(boardSize, difficulty); // Assuming the size of the board is 25 squares
        scoreBoard = new ScoreBoard();
    }

    // Getter methods

    /**
     * Gets the collection of squares on the game board.
     *
     * @return The squares on the game board.
     */
    public Squares getSquares() {
        return squares;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    /**
     * Checking if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Gets the obstacle ID of the square the player will land on.
     *
     * @param diceValue The value rolled on the dice.
     * @return The obstacle ID of the destination square.
     */
    public int getCurrentPlayerObstacleId(int diceValue){
        return squares.get(players.getCurrentPlayer().getPlayerPosition() + diceValue).getObstacleId();
    }

    /**
     * Checking if the game has been won.
     *
     * @return True if the game has been won, false otherwise.
     */
    public boolean isGameWon(){
        return players.getCurrentPlayer().getPlayerPosition() == squares.size() - 1;
    }

    // Setter methods

    /**
     * Setting the game over status.
     *
     * @param gameOver The new game over status.
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    // Gameplay methods

    /**
     * Moves the current player on the game board.
     * Updates player positions and square occupancy.
     */
    public void move(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());
        currentSquare.removePlayer();
        destinationSquare.setPlayer(players.getCurrentPlayer());
        players.getCurrentPlayer().setPlayerPosition(destinationSquare.squareId);
    }


    /**
     * Handles obstacles on the game board.
     * Resets required moves and applies obstacle effects.
     *
     */
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

    /**
     * Checks if the current move is valid.
     * Validates destination square occupancy and obstacle conditions.
     *
     * @return True if the move is valid, false otherwise.
     */
    public Boolean isValidMove(){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);

        // Checking if the move goes beyond the board size
        if(currentPlayerPosition + dice.getDiceValue() > squares.size()-1){
            return false;
        }

        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());

        //checking if destination square is occupied
        if(destinationSquare.getPlayer() != null){
            return false;
        }


        // Checking for obstacles and player conditions
        if(currentSquare.obstacle != null) {
            // Here, Player is in a fire pit
            if(players.getCurrentPlayer().isSkipTurn()){
                players.getCurrentPlayer().setSkipTurn(false);
                return false;
            }
           // Here, Player is in a spike pit
            if(dice.getDiceValue() < players.getCurrentPlayer().getRequiredMove()){
                return false;
            } else {
                //if the move is valid, reset the required moves for the current player
                players.getCurrentPlayer().setRequiredMove(0);
            }
        }

        // If no constraints are violated, then the move is valid
        return true;
    }
}
