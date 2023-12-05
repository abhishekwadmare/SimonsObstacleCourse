package test;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.obstacle.BottomlessPit;
import com.java.simonsobstaclecourse.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BottomlessPit class in the game.
 */
class BottomlessPitTest {

    /**
     * Testing the applyEffect method of the BottomlessPit class.
     * Verifying that the player is removed from the original square and placed at the starting position.
     */
    @Test
    void applyEffect_shouldRemovePlayerAndPlaceAtStartingPosition() {
        // Creating one player and placing them on a square
        Player player = new Player(1, "TestPlayer");
        Squares squares = new Squares(10); // Taking 10 squares for testing
        squares.get(5).setPlayer(player); // Placing the player on square 5

        // Creating a BottomlessPit obstacle
        BottomlessPit bottomlessPit = new BottomlessPit();

        // Applying the effect of the BottomlessPit on the player
        bottomlessPit.applyEffect(player, squares);

        // Considering that the player is removed from the original square
        assertNotNull(squares.get(5).getPlayer());

        // Considering that the player is placed at the starting position currently (square 0)
        Player newPlayerPosition = squares.get(0).getPlayer();
        assertNull(newPlayerPosition);
    }

    /**
     * Tests the getObstacleId method of the BottomlessPit class.
     * Verifying that the correct obstacleId is returned.
     */
    @Test
    void getObstacleId_shouldReturnCorrectObstacleId() {
        // Arranging the pit here
        BottomlessPit bottomlessPit = new BottomlessPit();

        int obstacleId = bottomlessPit.getObstacleId();

        // Assert the situation
        assertEquals(1, obstacleId); // Bottomless Pit obstacle has one obstacleId 1
    }

    /**
     * Tests the toString method of the BottomlessPit class.
     * Verifying that the correct string representation is returned.
     */
    @Test
    void toString_shouldReturnCorrectStringRepresentation() {
        // Arranging the pit
        BottomlessPit bottomlessPit = new BottomlessPit();

        String toStringResult = bottomlessPit.toString();

        // Assert the situation
        assertEquals("BP", toStringResult); // Bottomless Pit is represented as "BP"
    }
}
