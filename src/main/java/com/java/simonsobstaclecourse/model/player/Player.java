package com.java.simonsobstaclecourse.model.player;

/**
 * Represents a player in the game.
 * Each player has a name, unique identifier, current position on the game board, required move value, and skip turn status.
 */
public class Player {

    /** The name of the player. */
    public String name;

    /** The unique identifier for the player. */
    int playerId;

    /** The current position of the player on the game board. */
    int playerPosition;

    /** The number of required moves for the player. */
    int requiredMove = 0;

    /** Flag indicating whether the player should skip their turn. */
    boolean skipTurn = false;

    /**
     * Constructing a player with the specified unique identifier and name.
     *
     * @param playerId The unique identifier for the player.
     * @param name     The name of the player.
     */
    public Player(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
        this.playerPosition = 0;
    }

    /**
     * Retrieving the current position of the player on the game board.
     *
     * @return The current position of the player.
     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
     * Retrieving the unique identifier of the player.
     *
     * @return The unique identifier of the player.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Retrieving the number of required moves for the player.
     *
     * @return The number of required moves for the player.
     */
    public int getRequiredMove() {
        return requiredMove;
    }

    /**
     * Sets the number of required moves for the player.
     *
     * @param requiredMove The new number of required moves for the player.
     */
    public void setRequiredMove(int requiredMove) {
        this.requiredMove = requiredMove;
    }

    /**
     * Checking if the player should skip their turn.
     *
     * @return True if the player should skip their turn, false otherwise.
     */
    public boolean isSkipTurn() {
        return skipTurn;
    }

    /**
     * Sets the skip turn status for the player.
     *
     * @param skipTurn The new skip turn status for the player.
     */
    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    /**
     * Sets the current position of the player on the game board.
     *
     * @param playerPosition The new position of the player on the game board.
     */
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * Providing a string representation of the player.
     *
     * @return A string representation of the player.
     */
    @Override
    public String toString() {
        return "Player " +  playerId + " : " + name;
    }
}
