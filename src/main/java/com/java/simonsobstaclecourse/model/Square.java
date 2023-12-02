package com.java.simonsobstaclecourse.model;

import com.java.simonsobstaclecourse.model.Player;

public class Square {
    int id;
    int playerId;
    public Square(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if(playerId != 0)
            return "[P" + playerId + "]";
        else
            return "[  ]";
    }

    public void setPlayer(int playerId){
        this.playerId = playerId;
    }

}
