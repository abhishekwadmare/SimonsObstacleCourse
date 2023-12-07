package test;

import com.java.simonsobstaclecourse.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Player class in the game.
 */
public class PlayerTest {

    /**
     * Tests the getPlayerPosition method of the Player class.
     * Verifying that the initial player position is 0.
     */
    @Test
    void testGetPlayerPosition() {
        Player player = new Player(1, "TestPlayer");
        assertEquals(0, player.getPlayerPosition(), "Initial player position should be 0");
    }

    /**
     * Tests the getPlayerId method of the Player class.
     * Verifying that the correct player ID is returned.
     */
    @Test
    void testGetPlayerId() {
        Player player = new Player(1, "TestPlayer");
        assertEquals(1, player.getPlayerId(), "Player ID should be 1");
    }

    /**
     * Tests the getRequiredMove method of the Player class.
     * Verifying that the initial required move is 0.
     */
    @Test
    void testGetRequiredMove() {
        Player player = new Player(1, "TestPlayer");
        assertEquals(0, player.getRequiredMove(), "Initial required move should be 0");
    }

    /**
     * Tests the setRequiredMove method of the Player class.
     * Verifying that the required move is correctly set.
     */
    @Test
    void testSetRequiredMove() {
        Player player = new Player(1, "TestPlayer");
        player.setRequiredMove(3);
        assertEquals(3, player.getRequiredMove(), "Required move should be set to 3");
    }

    /**
     * Tests the isSkipTurn method of the Player class.
     * Verifying that the initial skip turn status is false.
     */
    @Test
    void testIsSkipTurn() {
        Player player = new Player(1, "TestPlayer");
        assertFalse(player.isSkipTurn(), "Initial skip turn status should be false");
    }

    /**
     * Tests the setSkipTurn method of the Player class.
     * Verifying that the skip turn status is correctly set.
     */
    @Test
    void testSetSkipTurn() {
        Player player = new Player(1, "TestPlayer");
        player.setSkipTurn(true);
        assertTrue(player.isSkipTurn(), "Skip turn status should be set to true");
    }

    /**
     * Tests the setPlayerPosition method of the Player class.
     * Verifying that the player position is correctly set.
     */
    @Test
    void testSetPlayerPosition() {
        Player player = new Player(1, "TestPlayer");
        player.setPlayerPosition(5);
        assertEquals(5, player.getPlayerPosition(), "Player position should be set to 5");
    }

    /**
     * Tests the toString method of the Player class.
     * Verifying that the toString method returns the correct format.
     */
    @Test
    void testToString() {
        Player player = new Player(1, "TestPlayer");
        assertEquals("Player 1 : TestPlayer", player.toString(), "ToString should return correct format");
    }
}
