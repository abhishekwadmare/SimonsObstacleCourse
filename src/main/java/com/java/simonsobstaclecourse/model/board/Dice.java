package com.java.simonsobstaclecourse.model.board;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a six-sided dice used in the game.
 * Allows rolling the dice and retrieving the rolled value.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 */
public class Dice {

    /** The value obtained after rolling the dice. */
    private int diceValue;

    /**
     * Simulating rolling the dice by generating a random value between 1 and 9 (inclusive).
     */
    public void roll(){
        diceValue = ThreadLocalRandom.current().nextInt(1, 10);
    }

    /**
     * Retrieving the value obtained from the last dice roll.
     *
     * @return The value of the last dice roll.
     */
    public int getDiceValue() {
        return diceValue;
    }
}
