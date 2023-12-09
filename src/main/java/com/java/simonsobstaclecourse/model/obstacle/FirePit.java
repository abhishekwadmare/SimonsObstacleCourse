package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

/**
 * Represents a Fire Pit obstacle in the game.
 * Implements the Obstacle interface to define its effects and properties.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 *
 */
public class FirePit implements Obstacle {

    /** Identifier for the Fire Pit obstacle. */
    final int ObstacleId = 2;

    /**
     * Applying the effect of the Fire Pit obstacle on the current player.
     * Sets the skip turn flag for the current player.
     *
     * @param currentPlayer The player encountering the obstacle.
     * @param squares        The collection of squares on the game board.
     */
    @Override
    public void applyEffect(Players players, Squares squares) {
        players.getCurrentPlayer().setSkipTurn(true);
    }

    /**
     * Provides a string representation of the Fire Pit obstacle.
     *
     * @return A string representation of the Fire Pit obstacle.
     */
    @Override
    public String toString() {
        return "FP";
    }

    /**
     * Retrieving the identifier of the Fire Pit obstacle.
     *
     * @return The identifier of the Fire Pit obstacle.
     */
    @Override
    public int getObstacleId() {
        return ObstacleId;
    }
}
