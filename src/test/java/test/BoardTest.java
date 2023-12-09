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

import com.java.simonsobstaclecourse.model.board.*;
import com.java.simonsobstaclecourse.model.player.*;

public class BoardTest {

    // Test case for initialization and getter methods
    @Test
    public void testInitialization() {
        Dice dice = new Dice();
        int playerCount = 3;
        Players players = new Players(playerCount);
        int difficulty = 2;
        int boardSize = 25;

        Board board = new Board(dice, players, difficulty, boardSize);

        assertEquals(boardSize, board.getSquares().size());
        assertEquals(difficulty, 2);
        assertFalse(board.isGameOver());
        assertNotNull(board.getScoreBoard());
    }

    // Test case for setter methods
    @Test
    public void testSetters() {
        Board board = new Board(new Dice(), new Players(3), 1, 25);

        board.setGameOver(true);
        assertTrue(board.isGameOver());

        board.setDifficulty(3);
        assertEquals(3, board.getDifficulty());
    }


}
