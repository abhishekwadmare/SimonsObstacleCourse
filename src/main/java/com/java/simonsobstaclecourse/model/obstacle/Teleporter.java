package com.java.simonsobstaclecourse.model.obstacle;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

import java.util.concurrent.ThreadLocalRandom;

public class Teleporter implements Obstacle{
    final int ObstacleId = 4;
    @Override
    public void applyEffect(Players players, Squares squares) {
        Player player;

        //logic for teleporting other player
        if(players.getCurrentPlayer().getPlayerId()==1){
            player = players.get(1);
        } else {
            player = players.get(0);
        }

        int destination = ThreadLocalRandom.current().nextInt(player.getPlayerPosition(), squares.size());

        if(squares.get(destination).getPlayer() == null && squares.get(destination).getObstacleId() == 0){
            squares.get(player.getPlayerPosition()).removePlayer();
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
