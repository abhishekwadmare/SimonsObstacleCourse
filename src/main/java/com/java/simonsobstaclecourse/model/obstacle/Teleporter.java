package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Teleporter implements Obstacle{
    final int ObstacleId = 4;
    @Override
    public void applyEffect(Player player, Squares squares) {
        squares.get(player.getPlayerPosition()).removePlayer();
        int destination = ThreadLocalRandom.current().nextInt(player.getPlayerPosition(), squares.size());

        if(squares.get(destination).getPlayer() == null){
            squares.get(destination).setPlayer(player);
            player.setPlayerPosition(destination);
        }
    }

    @Override
    public String toString() {
        return "TP";
    }
    @Override
    public int getObstacleId() {
        return ObstacleId;
    }
}
