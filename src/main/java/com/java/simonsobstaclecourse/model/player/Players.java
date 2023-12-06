package com.java.simonsobstaclecourse.model.player;

import javafx.scene.control.Label;

import java.util.ArrayList;

public class Players extends ArrayList<Player> {

    private int currentPlayerId;
    private final int playerCount;

    public Players(int playerCount) {
        super(playerCount);
        this.playerCount = playerCount;
        currentPlayerId = 1;
    }

    public int getCurrentPlayerId() {
        return currentPlayerId;
    }

    public Player getCurrentPlayer(){
        return this.get(currentPlayerId-1);
    }

    public void switchPlayer(Label currentPlayer){
        currentPlayerId = (currentPlayerId % playerCount) + 1;
        currentPlayer.setText(getCurrentPlayer().toString());
//        currentPlayerId = currentPlayerId == 1 ? 2:1;
    }

}
