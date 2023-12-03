package com.java.simonsobstaclecourse.model.board;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceValue;
    public void roll(){
        diceValue = ThreadLocalRandom.current().nextInt(1, 10);
    }

    public int getDiceValue() {
        return diceValue;
    }
}
