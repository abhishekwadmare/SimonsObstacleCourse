package com.java.simonsobstaclecourse.model.board;

public class Square {
    int squareId;
    int playerId;
    Obstacle obstacle;
    public Square(int squareId) {
        this.squareId = squareId;
    }

    @Override
    public String toString() {
        if(squareId == 0){
            return "[Start]";
        }else if(playerId != 0)
            return "[P" + playerId + "]";
        else
            return "[  ]";

    }

    public void setPlayer(int playerId){
        this.playerId = playerId;
    }
    public void removePlayer(){
        this.playerId = 0;
    }

}
