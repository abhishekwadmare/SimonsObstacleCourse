package test;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.view.GameView;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the GameView class in the game.
 */
class GameViewTest {

    /**
     * Tests the displayWinMessage method of the GameView class.
     * Verifying that the correct win message is displayed.
     */
    @Test
    void testDisplayWinMessage() {
        GameView gameView = new GameView();

        // Redirecting standard output for testing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Player mockPlayer = mock(Player.class);
        when(mockPlayer.toString()).thenReturn("Player 1 : TestPlayer");

        gameView.displayWinMessage(mockPlayer);

        // Restoring standard output
        System.setOut(System.out);

        // Adding assertions based on specific requirements
        assertEquals("Player 1 : TestPlayer won the game", outContent.toString());
    }

    /**
     * Tests the displayInvalidMoveMessage method of the GameView class.
     * Verifying that the correct invalid move message is displayed.
     */
    @Test
    void testDisplayInvalidMoveMessage() {
        GameView gameView = new GameView();

        // Redirecting standard output for testing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        gameView.displayInvalidMoveMessage();

        // Restoring standard output
        System.setOut(System.out);

        // Adding assertions based on specific requirements
        assertEquals("Move not possible", outContent.toString().trim());
    }

    /**
     * Tests the getCommand method of the GameView class.
     * Verifying that the correct command is retrieved from the user input.
     */
    @Test
    void testGetCommand() {
        // Redirecting standard input for testing
        ByteArrayInputStream inContent = new ByteArrayInputStream("MOVE".getBytes());
        System.setIn(inContent);

        GameView gameView = new GameView();

        // Adding assertions based on specific requirements
        assertEquals("MOVE", gameView.getCommand());

        // Restoring standard input
        System.setIn(System.in);
    }

    /**
     * Tests the getPlayers method of the GameView class.
     * Verifying that the correct number of players and their names are retrieved from the user input.
     */
    @Test
    void testGetPlayers() {
        // Redirecting standard input for testing
        ByteArrayInputStream inContent = new ByteArrayInputStream("2\nPlayer1\nPlayer2\n".getBytes());
        System.setIn(inContent);

        GameView gameView = new GameView();
        Players players = gameView.getPlayers();

        // Restoring standard input
        System.setIn(System.in);

        // Adding assertions based on your specific requirements
        assertEquals(2, players.size());
        assertEquals("Player1", players.get(0).name);
        assertEquals("Player2", players.get(1).name);
    }

    /**
     * Tests the getToTransportPlayer method of the GameView class.
     * Verifying that the correct player ID to transport is retrieved from the user input.
     */
    @Test
    void testGetToTransportPlayer() {
        // Redirecting standard input for testing
        ByteArrayInputStream inContent = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(inContent);

        GameView gameView = new GameView();

        // Adding assertions based on specific requirements
        assertEquals(3, gameView.getToTransportPlayer());

        // Restoring standard input
        System.setIn(System.in);
    }

    /**
     * Tests the getMoveChoice method of the GameView class.
     * Verifying that the correct move choice is retrieved from the user input.
     */
    @Test
    void testGetMoveChoice() {
        // Redirecting standard input for testing
        ByteArrayInputStream inContent = new ByteArrayInputStream("y\n".getBytes());
        System.setIn(inContent);

        GameView gameView = new GameView();

        // Adding assertions based on your specific requirements
        assertTrue(gameView.getMoveChoice());

        // Restoring standard input
        System.setIn(System.in);
    }
}
