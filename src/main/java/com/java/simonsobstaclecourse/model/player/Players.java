package com.java.simonsobstaclecourse.model.player;

import java.util.ArrayList;

/**
 * Representing a collection of players in the game.
 * Extends the ArrayList class to provide additional functionality for managing players.
 */
public class Players extends ArrayList<Player> {

    /** The unique identifier of the current player. */
    private int currentPlayerId;

    /** The total number of players in the collection. */
    private final int playerCount;

    /**
     * Constructing a collection of players with the specified number of players.
     *
     * @param playerCount The total number of players in the collection.
     */
    public Players(int playerCount) {
        super(playerCount);
        this.playerCount = playerCount;
        currentPlayerId = 1;
    }

    /**
     * Retrieving the unique identifier of the current player.
     *
     * @return The unique identifier of the current player.
     */
    public int getCurrentPlayerId() {
        return currentPlayerId;
    }

    /**
     * Retrieving the current player from the collection.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer(){
        return this.get(currentPlayerId-1);
    }

    /**
     * Switch the current player to the next player in the collection.
     */
    public void switchPlayer(){
        currentPlayerId = (currentPlayerId % playerCount) + 1;
    }
}
