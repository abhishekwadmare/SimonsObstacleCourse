package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Representing the Teleporter obstacle in the game.
 * Implements the Obstacle interface to define its effects and properties.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 *
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
    public void applyEffect(Players players, Squares squares) {
        Player player;

        //logic for teleporting other player
        if(players.getCurrentPlayer().getPlayerId()==1){
            player = players.get(1);
        } else {
            player = players.get(0);
        }
        // Generating a random destination square index within the remaining squares
        int destination = ThreadLocalRandom.current().nextInt(player.getPlayerPosition(), squares.size());

        // Checking if the destination square is unoccupied and destination has no obstacles
        if(squares.get(destination).getPlayer() == null && squares.get(destination).getObstacleId() == 0){
            squares.get(player.getPlayerPosition()).removePlayer();

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
