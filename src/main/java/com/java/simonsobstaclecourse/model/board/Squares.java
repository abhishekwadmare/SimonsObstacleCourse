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
    public Squares(int size){
        super(size);
        addSquares(size);
    }

    /**
     * Adding squares to the collection based on the specified size.
     * Obstacles are added to specific squares based on a pattern.
     *
     * @param size The size of the collection, representing the number of squares on the game board.
     */
    public void addSquares(int size){
        int obstacleId = 1;
        for (int i = 0; i < size; i++) {
            // Check if the square index corresponds to a position for an obstacle
            if(i % Math.sqrt(size) == 0 && i != 0 && i != size-1){
                this.add(new Square(i, obstacleId));
                // Cycle through obstacle types (1 to 4)
                obstacleId = (obstacleId % 4) + 1;
            } else {
                this.add(new Square(i));
            }
        }
    }
}
