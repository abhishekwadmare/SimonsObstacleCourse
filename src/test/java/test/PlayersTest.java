package test;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;

import javafx.scene.control.Label;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Players class in the game.
 */
public class PlayersTest {

    /**
     * Tests the getCurrentPlayer method of the Players class.
     * Verifying that the correct current player is retrieved after adding players.
     */
    @Test
    public void testGetCurrentPlayer() {
        int playerCount = 3;
        Players players = new Players(playerCount);

        // Adding players to the collection before getting the current player
        players.add(new Player(1, "Player1"));
        players.add(new Player(2, "Player2"));
        players.add(new Player(3, "Player3"));

        Player currentPlayer = players.getCurrentPlayer();
        assertNotNull(currentPlayer);
        assertEquals(1, currentPlayer.getPlayerId());
    }


}
