package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Teleporter implements Obstacle{
    final int ObstacleId = 4;
    @Override
    public void applyEffect(Player currentPlayer, Squares squares) {
        squares.get(currentPlayer.getPlayerPosition()).removePlayer();
        int destination = ThreadLocalRandom.current().nextInt(0, squares.size());
        if(destination != 0){
            squares.get(destination).setPlayer(currentPlayer);
        }
        currentPlayer.setPlayerPosition(destination);
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
