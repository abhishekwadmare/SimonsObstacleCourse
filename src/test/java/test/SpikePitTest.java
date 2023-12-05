package test;

import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.obstacle.SpikePit;
import com.java.simonsobstaclecourse.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SpikePit class in the game.
 */
class SpikePitTest {

    /**
     * Tests the applyEffect method of the SpikePit class.
     * Verifying that applyEffect sets the required move to 4.
     */
    @Test
    void applyEffect_shouldSetRequiredMoveTo4() {
        // Arrange the scenario
        SpikePit spikePit = new SpikePit();
        Player currentPlayer = new Player(1, "TestPlayer");
        Squares squares = new Squares(10); // We can adjust the size based on your board configuration

        // Act
        spikePit.applyEffect(currentPlayer, squares);

        // Assert
        assertEquals(4, currentPlayer.getRequiredMove());
    }

    /**
     * Tests the toString method of the SpikePit class.
     * Verifying that toString returns "SP".
     */
    @Test
    void toString_shouldReturnSP() {
        // Arrange the scenario
        SpikePit spikePit = new SpikePit();

        // Act
        String result = spikePit.toString();

        // Assert
        assertEquals("SP", result);
    }

    /**
     * Tests the getObstacleId method of the SpikePit class.
     * Verifying that getObstacleId returns 3.
     */
    @Test
    void getObstacleId_shouldReturn3() {
        // Arrange the scenario
        SpikePit spikePit = new SpikePit();

        // Act
        int result = spikePit.getObstacleId();

        // Assert
        assertEquals(3, result);
    }
}
