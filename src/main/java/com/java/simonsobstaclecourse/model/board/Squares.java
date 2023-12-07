package com.java.simonsobstaclecourse.model.board;

import java.util.ArrayList;

/**
 * Representing a collection of squares on the game board in project.
 * Extends the ArrayList class to provide additional functionality for managing squares.
 */
public class Squares extends ArrayList<Square> {

    /**
     * Constructs a collection of squares with the specified size and initializes them.
     *
     * @param size The size of the collection, representing the number of squares on the game board.
     */
    public Squares(int size, int difficulty){
        super(size);
        addSquares(size, difficulty);
    }

    /**
     * Adding squares to the collection based on the specified size.
     * Obstacles are added to specific squares based on a pattern.
     *
     * @param size The size of the collection, representing the number of squares on the game board.
     */
    public void addSquares(int size, int difficulty){
        int obstacleId = 1;
        int obstacleSpreader;

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
                // Cycle through obstacle types (1 to 4)
                obstacleId = (obstacleId % 4) + 1;
            } else {
                this.add(new Square(i));
            }
        }
    }
}
