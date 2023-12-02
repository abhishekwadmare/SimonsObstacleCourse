package com.java.simonsobstaclecourse.model;

import java.util.Random;

public class Dice {
    int diceValue;
    Random rand = new Random();
    public void roll(){
        diceValue = rand.nextInt(6) + 1;
    }

    public int getDiceValue() {
        return diceValue;
    }
}
