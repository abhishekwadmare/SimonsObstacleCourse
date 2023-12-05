package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

/**
 * Representing a Spike Pit obstacle in the game.
 * Implements the Obstacle interface to define its effects and properties.
 */
public class SpikePit implements Obstacle {

    /** Identifier for the Spike Pit obstacle. */
    final int ObstacleId = 3;

    /**
     * Applying the effect of the Spike Pit obstacle on the current player.
     * Sets the required move for the current player to 4.
     *
     * @param currentPlayer The player encountering the obstacle.
     * @param squares        The collection of squares on the game board.
     */
    @Override
    public void applyEffect(Player currentPlayer, Squares squares) {
        currentPlayer.setRequiredMove(4);
    }

    /**
     * Providing a string representation of the Spike Pit obstacle.
     *
     * @return A string representation of the Spike Pit obstacle.
     */
    @Override
    public String toString() {
        return "SP";
    }

    /**
     * Retrieving the identifier of the Spike Pit obstacle.
     *
     * @return The identifier of the Spike Pit obstacle.
     */
    @Override
    public int getObstacleId() {
        return ObstacleId;
    }
}
