package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Teleporter class in the game.
 */
import com.java.simonsobstaclecourse.model.obstacle.Teleporter;

public class TeleporterTest {


    // Test case for retrieving the identifier of the Teleporter obstacle
    @Test
    public void testGetObstacleId() {
        Teleporter teleporter = new Teleporter();
        assertEquals(4, teleporter.getObstacleId());
    }
}
