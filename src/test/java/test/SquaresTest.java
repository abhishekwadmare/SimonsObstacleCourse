package test;

import com.java.simonsobstaclecourse.model.board.Squares;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Squares class in the game.
 */
public class SquaresTest {

    /**
     * Tests the addSquares method of the Squares class.
     * Verifying that squares are added based on the specified size and obstacle placement logic.
     */
    @Test
    void testAddSquares() {
        // Creating an instance of the Squares class with a specified size
        int size = 25; // You can adjust the size based on your actual requirements
        Squares squares = new Squares(size);

        // Verifying that the number of squares matches the specified size
        assertEquals(size, squares.size());

        // Verifying the placement of obstacles based on the addSquares logic
        // For example, if size is 25, obstacle placement should occur at positions 5, 10, 15, and 20
        assertEquals(0, squares.get(0).getObstacleId()); // No obstacle at the start
        assertEquals(0, squares.get(4).getObstacleId()); // No obstacle before the first placement
        assertEquals(1, squares.get(5).getObstacleId()); // Obstacle type 1 at position 5
        assertEquals(2, squares.get(10).getObstacleId()); // Obstacle type 2 at position 10
        assertEquals(3, squares.get(15).getObstacleId()); // Obstacle type 3 at position 15
        assertEquals(4, squares.get(20).getObstacleId()); // Obstacle type 4 at position 20
        assertEquals(0, squares.get(24).getObstacleId()); // No obstacle at the end
    }
}
