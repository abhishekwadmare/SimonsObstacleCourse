package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;

public interface Obstacle {
    public void applyEffect(Player currentPlayer, Squares squares);

    public int getObstacleId();
}
