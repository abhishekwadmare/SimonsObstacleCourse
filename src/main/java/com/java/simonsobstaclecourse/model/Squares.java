package com.java.simonsobstaclecourse.model;

import java.util.ArrayList;

public class Squares extends ArrayList<Square> {
    public Squares(int size){
        for(int i = 0; i < size; i++){
            this.add(new Square(i));
        }
    }

}
