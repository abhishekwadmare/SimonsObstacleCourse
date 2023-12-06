package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

public class SpikePit implements Obstacle{
    final int ObstacleId = 3;

    @Override
    public void applyEffect(Players players, Squares squares) {
        players.getCurrentPlayer().setRequiredMove(4);
    }

    @Override
    public String toString() {
        return "SP";
    }

    @Override
    public int getObstacleId() {
        return ObstacleId;
    }
}
