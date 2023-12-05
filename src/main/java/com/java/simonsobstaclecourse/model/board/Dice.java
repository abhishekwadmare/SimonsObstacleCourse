package com.java.simonsobstaclecourse.model.board;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a six-sided dice used in the game.
 * Allows rolling the dice and retrieving the rolled value.
 */
public class Dice {

    /** The value obtained after rolling the dice. */
    private int diceValue;

    /**
     * Simulating rolling the dice by generating a random value between 1 and 6 (inclusive).
     * For testing purposes, the user is prompted to manually input the dice value.
     */
    public void roll(){
  
        // diceValue = ThreadLocalRandom.current().nextInt(1, 7);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dice value:");
        diceValue = scanner.nextInt();
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
