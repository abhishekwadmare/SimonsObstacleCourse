package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.board.Square;

import java.util.ArrayList;

public class Squares extends ArrayList<Square> {
    public Squares(int size, int difficulty){
        super(size);
        addSquares(size, difficulty);
    }

    public void addSquares(int size, int difficulty){
        int obstacleId = 1;
        int obstacleSpreader ;

        if(difficulty == 1){
            //easy
            obstacleSpreader = size/3;
        } else if(difficulty == 2){
            //normal
            obstacleSpreader = (int)Math.sqrt(size);
        } else if(difficulty == 3){
            //difficult
            obstacleSpreader = (int)Math.cbrt(size);
        } else {
            //normal
            obstacleSpreader = (int)Math.sqrt(size);
        }


        for (int i = 0; i < size; i++) {
            if(i % obstacleSpreader == 0 && i != 0 && i != size-1){
                this.add(new Square(i, obstacleId));
                obstacleId = (obstacleId % 4) + 1;
            } else {
                this.add(new Square(i));
            }
        }
    }

}
