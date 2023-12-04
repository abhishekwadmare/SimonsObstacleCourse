package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.board.Square;

import java.util.ArrayList;

public class Squares extends ArrayList<Square> {
    public Squares(int size){
        super(size);
        addSquares(size);
    }

    public void addSquares(int size){
        int obstacleId = 1;
        for (int i = 0; i < size; i++) {
            if(i % Math.sqrt(size) == 0 && i != 0 && i != size-1){
                this.add(new Square(i, obstacleId));
                obstacleId = (obstacleId % 4) + 1;
            } else {
                this.add(new Square(i));
            }
        }
    }

}
