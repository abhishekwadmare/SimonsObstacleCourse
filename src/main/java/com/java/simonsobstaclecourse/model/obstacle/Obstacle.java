package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

public interface Obstacle {
    public void applyEffect(Players players, Squares squares);

    public int getObstacleId();
}
