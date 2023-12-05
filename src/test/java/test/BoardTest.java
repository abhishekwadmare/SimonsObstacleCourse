package test;

import com.java.simonsobstaclecourse.model.board.Board;
import com.java.simonsobstaclecourse.model.board.Dice;
import com.java.simonsobstaclecourse.model.board.Square;
import com.java.simonsobstaclecourse.model.board.Squares;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.model.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the Board class in the game.
 */
class BoardTest {
    private Board board;
    private Players players;
    private Dice dice;

    /**
     * Setting up the test environment by creating mock objects and an actual Board instance.
     */
    @BeforeEach
    void setUp() {
        // Creating mock objects for setup
        players = mock(Players.class);
        dice = mock(Dice.class);

        // Creating an actual Board instance
        board = new Board(dice, players);
    }

    /**
     * Tests the getSquares method of the Board class.
     */
    @Test
    void testGetSquares() {
        assertNotNull(board.getSquares());
    }

    /**
     * Tests the isGameOver method of the Board class.
     */
    @Test
    void testIsGameOver() {
        assertFalse(board.isGameOver());
    }

    /**
     * Tests the getCurrentPlayerObstacleId method of the Board class.
     */
    @Test
    void testGetCurrentPlayerObstacleId() {
        // Mock player test
        Player mockPlayer = mock(Player.class);
        when(players.getCurrentPlayer()).thenReturn(mockPlayer);
        when(mockPlayer.getPlayerPosition()).thenReturn(0);

        // Test for Mock squares
        Squares mockSquares = mock(Squares.class);
        when(mockSquares.get(anyInt())).thenReturn(new Square(0));

        // Test for obstacle ID
        int obstacleId = board.getCurrentPlayerObstacleId(2);

        // Verification
        assertEquals(0, obstacleId);
    }

    /**
     * Tests the isGameWon method of the Board class.
     */
    @Test
    void testIsGameWon() {
        // Mock player test
        Player mockPlayer = mock(Player.class);
        when(players.getCurrentPlayer()).thenReturn(mockPlayer);
        when(mockPlayer.getPlayerPosition()).thenReturn(24);

        assertTrue(board.isGameWon());
    }

    /**
     * Tests the setGameOver method of the Board class.
     */
    @Test
    void testSetGameOver() {
        board.setGameOver(true);
        assertTrue(board.isGameOver());
    }

    /**
     * Tests the handleObstacle method of the Board class.
     */
    @Test
    void testHandleObstacle() {
        // Mock player test 
        Player mockPlayer = mock(Player.class);
        when(players.getCurrentPlayer()).thenReturn(mockPlayer);

        // Mock squares test
        Squares mockSquares = mock(Squares.class);
        when(mockSquares.get(anyInt())).thenReturn(new Square(0));

        // Testing
        board.handelObstacle(mockPlayer);
    }
}
