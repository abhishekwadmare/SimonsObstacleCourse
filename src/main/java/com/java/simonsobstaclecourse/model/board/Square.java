package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.obstacle.*;
import com.java.simonsobstaclecourse.model.player.Player;

public class Square {
    int squareId;
    Player player;
    Obstacle obstacle;

    public Square(int squareId) {
        this.squareId = squareId;
    }
    public Square(int squareId, int ObstacleId) {
        this.squareId = squareId;
        setObstacle(ObstacleId);
    }

    @Override
    public String toString() {
        if(player != null && obstacle != null)
            return "[P" + player.getPlayerId() + " " + obstacle + "]";
        else if(obstacle != null)
            return "[ " + obstacle + "]";
        else if(player != null)
            return "[P" + player.getPlayerId() + "]";
        else
            return "[  ]";
    }

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

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getObstacleId() {
        if(obstacle == null)
            return 0;
        return obstacle.getObstacleId();

    }

    public void removePlayer(){
        this.player = null;
    }
}
