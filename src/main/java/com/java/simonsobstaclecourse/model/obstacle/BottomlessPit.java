package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

public class BottomlessPit implements Obstacle{

    final int ObstacleId = 1;

    @Override
    public void applyEffect(Players players, Squares squares) {

        squares.get(players.getCurrentPlayer().getPlayerPosition()).removePlayer();
        players.getCurrentPlayer().setPlayerPosition(0);
    }

    @Override
    public int getObstacleId() {
        return ObstacleId;
    }

    @Override
    public String toString() {
        return "BP";
    }
}
