package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

public class FirePit implements Obstacle{
    final int ObstacleId = 2;

    @Override
    public void applyEffect(Players players, Squares squares) {
        players.getCurrentPlayer().setSkipTurn(true);
    }

    @Override
    public String toString() {
        return "FP";
    }

    @Override
    public int getObstacleId() {
        return ObstacleId;
    }

}
