package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Representing the Teleporter obstacle in the game.
 * Implements the Obstacle interface to define its effects and properties.
 */
public class Teleporter implements Obstacle {

    /** Identifier for the Teleporter obstacle. */
    final int ObstacleId = 4;

    /**
     * Applying the effect of the Teleporter obstacle on the specified player.
     * Removes the player from their current square and teleports them to a random destination square.
     *
     * @param player  The player encountering the obstacle.
     * @param squares The collection of squares on the game board.
     */
    @Override
    public void applyEffect(Player player, Squares squares) {
        squares.get(player.getPlayerPosition()).removePlayer();

        // Generating a random destination square index within the remaining squares
        int destination = ThreadLocalRandom.current().nextInt(player.getPlayerPosition(), squares.size());

        // Checking if the destination square is unoccupied
        if(squares.get(destination).getPlayer() == null){
            squares.get(destination).setPlayer(player);
            player.setPlayerPosition(destination);
        }
    }

    /**
     * Providing a string representation of the Teleporter obstacle.
     *
     * @return A string representation of the Teleporter obstacle.
     */
    @Override
    public String toString() {
        return "TP";
    }

    /**
     * Retrieving the identifier of the Teleporter obstacle.
     *
     * @return The identifier of the Teleporter obstacle.
     */
    @Override
    public int getObstacleId() {
        return ObstacleId;
    }
}
