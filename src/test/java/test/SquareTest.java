package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.java.simonsobstaclecourse.model.board.Square;
import com.java.simonsobstaclecourse.model.player.Player;

public class SquareTest {

    // Test case for constructing a square with no obstacle or player
    @Test
    public void testEmptySquareToString() {
        Square square = new Square(1);
        assertEquals("    ", square.toString());
    }

    // Test case for constructing a square with a player
    @Test
    public void testSquareWithPlayerToString() {
        Square square = new Square(2);
        Player player = new Player(1,"Simo");
        square.setPlayer(player);
        assertEquals("[P1]", square.toString());
    }

    // Test case for constructing a square with an obstacle
    @Test
    public void testSquareWithObstacleToString() {
        Square square = new Square(3, 1);
        assertEquals("[B__P]", square.toString());
    }

    // Test case for constructing a square with both player and obstacle
    @Test
    public void testSquareWithPlayerAndObstacleToString() {
        Square square = new Square(4, 2);
        Player player = new Player(2,"Ram");
        square.setPlayer(player);
        assertEquals("[F_P2_P]", square.toString());
    }

    // Test case for setting an obstacle on the square
    @Test
    public void testSetObstacle() {
        Square square = new Square(5);
        square.setObstacle(3);
        assertEquals(3, square.getObstacleId());
    }

    // Test case for removing a player from the square
    @Test
    public void testRemovePlayer() {
        Square square = new Square(6);
        Player player = new Player(3,"Jeev");
        square.setPlayer(player);
        square.removePlayer();
        assertNull(square.getPlayer());
    }

    // Test case for retrieving the obstacle identifier on the square with no obstacle
    @Test
    public void testGetObstacleIdWithoutObstacle() {
        Square square = new Square(7);
        assertEquals(0, square.getObstacleId());
    }

    // Test case for retrieving the obstacle identifier on the square with an obstacle
    @Test
    public void testGetObstacleIdWithObstacle() {
        Square square = new Square(8, 4);
        assertEquals(4, square.getObstacleId());
    }


}
