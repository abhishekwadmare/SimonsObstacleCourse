package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.obstacle.*;
import com.java.simonsobstaclecourse.model.player.Player;

/**
 * Representing a square on the game board in the game.
 * Each square can contain a player, an obstacle, or both.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 */
public class Square {

    /** The unique identifier for the square. */
    int squareId;

    /** The player occupying the square. */
    Player player;

    /** The obstacle present on the square. */
    public Obstacle obstacle;

    /**
     * Constructs a square with a specified square identifier.
     *
     * @param squareId The unique identifier for the square.
     */
    public Square(int squareId) {
        this.squareId = squareId;
    }

    /**
     * Constructs a square with a specified square identifier and an obstacle.
     *
     * @param squareId    The unique identifier for the square.
     * @param ObstacleId The identifier of the obstacle to be placed on the square.
     */
    public Square(int squareId, int ObstacleId) {
        this.squareId = squareId;
        setObstacle(ObstacleId);
    }

    /**
     * Provides a string representation of the square, including player and obstacle information if present.
     *
     * @return A string representation of the square.
     */
    @Override
    public String toString() {
        if(player != null && obstacle != null)
            return "["+ obstacle.toString().charAt(0) +"_P" + player.getPlayerId() + "_" + obstacle.toString().charAt(1) + "]";
        else if(obstacle != null)
            return "["+ obstacle.toString().charAt(0)+ "__" + obstacle.toString().charAt(1) + "]";
        else if(player != null)
            return "[P" + player.getPlayerId() + "]";
        else
            return "    ";
    }

    /**
     * Sets an obstacle on the square based on the specified obstacle identifier.
     *
     * @param ObstacleId The identifier of the obstacle to be placed on the square.
     * @throws IllegalArgumentException If the specified obstacle identifier is invalid.
     */
    public void setObstacle(int ObstacleId) {
        switch(ObstacleId){
            case 1: obstacle = new BottomlessPit();
            break;
            case 2: obstacle = new FirePit();
            break;
            case 3: obstacle = new SpikePit();
            break;
            case 4: obstacle = new Teleporter();
            break;
            default:
                throw new IllegalArgumentException("Invalid Obstacle Id");
        }
    }

    /**
     * Setting up a player on the square.
     *
     * @param player The player to be placed on the square.
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * Retrieving the player on the square.
     *
     * @return The player on the square, or null if no player is present.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Retrieving the identifier of the obstacle on the square.
     *
     * @return The identifier of the obstacle, or 0 if no obstacle is present.
     */
    public int getObstacleId() {
        if(obstacle == null)
            return 0;
        return obstacle.getObstacleId();
    }

    /**
     * Removing the player from the square.
     */
    public void removePlayer(){
        this.player = null;
    }
}
