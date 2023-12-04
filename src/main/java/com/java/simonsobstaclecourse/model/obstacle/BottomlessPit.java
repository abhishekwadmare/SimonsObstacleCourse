package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

public class BottomlessPit implements Obstacle{

    final int ObstacleId = 1;

    @Override
    public void applyEffect(Player currentPlayer, Squares squares) {
        squares.get(currentPlayer.getPlayerPosition()).removePlayer();
        currentPlayer.setPlayerPosition(0);
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
