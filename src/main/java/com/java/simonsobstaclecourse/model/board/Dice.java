package com.java.simonsobstaclecourse.model.board;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceValue;
    public void roll(){
//        diceValue = ThreadLocalRandom.current().nextInt(1, 10);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dice value:");
        diceValue = scanner.nextInt();
    }

    public int getDiceValue() {
        return diceValue;
    }
}
