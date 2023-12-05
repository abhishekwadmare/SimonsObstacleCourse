package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

/**
 * An interface representing obstacles in the game.
 * Obstacles define effects to be applied on players and provide unique identifiers.
 */
public interface Obstacle {

    /**
     * Applying the effect of the obstacle on the current player.
     *
     * @param currentPlayer The player encountering the obstacle.
     * @param squares        The collection of squares on the game board.
     */
    void applyEffect(Player currentPlayer, Squares squares);

    /**
     * Retrieving the unique identifier of the obstacle.
     *
     * @return The identifier of the obstacle.
     */
    int getObstacleId();
}
