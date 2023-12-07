package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

/**
 * Represents a Bottomless Pit obstacle in the game.
 * Implements the Obstacle interface to define its effects and properties.
 */
public class BottomlessPit implements Obstacle{

    /** Identifier for the Bottomless Pit obstacle. */
    final int ObstacleId = 1;

    /**
     * Applying the effect of the Bottomless Pit obstacle on the current player.
     * Removing the player from their current square and places them at the starting position.
     *
     * @param currentPlayer The player encountering the obstacle.
     * @param squares        The collection of squares on the game board.
     */
    @Override
    public void applyEffect(Players players, Squares squares) {

        squares.get(players.getCurrentPlayer().getPlayerPosition()).removePlayer();
        players.getCurrentPlayer().setPlayerPosition(0);
    }

    /**
     * Retrieving the identifier of the Bottomless Pit obstacle.
     *
     * @return The identifier of the Bottomless Pit obstacle.
     */
    @Override
    public int getObstacleId() {
        return ObstacleId;
    }

    /**
     * Providing a string representation of the Bottomless Pit obstacle.
     *
     * @return A string representation of the Bottomless Pit obstacle.
     */
    @Override
    public String toString() {
        return "BP";
    }
}
