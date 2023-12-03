package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.board.Square;

import java.util.ArrayList;

public class Squares extends ArrayList<Square> {
    public Squares(int size){
        super(size);
        for(int i = 0; i < size; i++){
            this.add(new Square(i));
        }
    }

}
