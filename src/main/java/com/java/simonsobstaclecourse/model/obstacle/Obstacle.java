package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

/**
 * An interface representing obstacles in the game.
 * Obstacles define effects to be applied on players and provide unique identifiers.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 *
 */
public interface Obstacle {
    /**
     * Applying the effect of the obstacle on the current player.
     *
     * @param currentPlayer The player encountering the obstacle.
     * @param squares        The collection of squares on the game board.
     */
    public void applyEffect(Players players, Squares squares);

    /**
     * Retrieving the unique identifier of the obstacle.
     *
     * @return The identifier of the obstacle.
     */
     public int getObstacleId();
}
