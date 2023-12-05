package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

/**
 * Represents the game board for Simon's Obstacle Course.
 * This manages player movements, obstacles, and game state.
 */
public class Board {

    // Attributes

    /** Collection of squares on the game board. */
    private Squares squares;

    /** Player information and management. */
    private Players players;

    /** Dice for generating random values during the game. */
    private Dice dice;

    /** Flag indicating whether the game is over. */
    private boolean gameOver;

    // Constructor

    /**
     * Constructs a Board with the specified dice and players.
     *
     * @param dice    The dice used in the game.
     * @param players The collection of players in the game.
     */
    public Board(Dice dice, Players players){
        this.dice = dice;
        this.players = players;

        // Initializing game state
        gameOver = false;
        squares = new Squares(25); // Assuming the size of the board is 25 squares
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
     * @param player The player encountering the obstacle.
     */
    public void handelObstacle(Player player){
        int currentPlayerPosition = players.getCurrentPlayer().getPlayerPosition();
        Square currentSquare = squares.get(currentPlayerPosition);
        Square destinationSquare = squares.get(currentPlayerPosition + dice.getDiceValue());

        // Resetting required moves for the current player if valid move
        if(currentSquare.obstacle != null && dice.getDiceValue() >= players.getCurrentPlayer().getRequiredMove()){
            players.getCurrentPlayer().setRequiredMove(0);
        }

        // Applying obstacle effects to the player
        if(destinationSquare.obstacle != null)
            destinationSquare.obstacle.applyEffect(player, squares);
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

        // Checking if the future square is occupied
        if(destinationSquare.getPlayer() != null){
            return false;
        }

        // Checking for obstacles and player conditions
        if(currentSquare.obstacle != null) {
            // Here, Player is in a fire pit
            if(players.getCurrentPlayer().isSkipTurn()){
                players.getCurrentPlayer().setSkipTurn(false);
                return false;
            } else if(dice.getDiceValue() < players.getCurrentPlayer().getRequiredMove()){
                // Here, Player is in a spike pit
                return false;
            }
        }

        // If no constraints are violated, then the move is valid
        return true;
    }
}
