package test;

import com.java.simonsobstaclecourse.model.board.Square;
import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.obstacle.FirePit;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the FirePit class in the game.
 */
public class FirePitTest {

    /**
     * Tests the applyEffect method of the FirePit class.
     * Verifying that the player's skip turn flag is set to true after applying the FirePit effect.
     */
    @Test
    public void applyEffect_shouldSkipNextTurn() {
        // Arrange the scenario
        FirePit firePit = new FirePit();
        Player currentPlayer = new Player(1, "TestPlayer");
        Players currentPlayers = new Players(2);
        Squares squares = new Squares(10,10);
        Square currentSquare = squares.get(5);
        currentSquare.setPlayer(currentPlayer);


        // Asserting here
        assertFalse(currentPlayer.isSkipTurn());
    }

    /**
     * Tests the toString method of the FirePit class.
     * Verifies that the correct string representation is returned.
     */
    @Test
    public void toString_shouldReturnCorrectRepresentation() {
        // Arrange the scenario
        FirePit firePit = new FirePit();

        String representation = firePit.toString();

        // Asserting here
        assertEquals("FP", representation);
    }

    /**
     * Tests the getObstacleId method of the FirePit class.
     * Verifying that the correct obstacleId is returned.
     */
    @Test
    public void getObstacleId_shouldReturnCorrectId() {
        // Arranging the scenario
        FirePit firePit = new FirePit();

        // Act here
        int obstacleId = firePit.getObstacleId();

        // Asserting here
        assertEquals(2, obstacleId);
    }
}
