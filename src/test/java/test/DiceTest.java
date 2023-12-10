package test;

import com.java.simonsobstaclecourse.model.board.Dice;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the Dice class in the game.
 */
class DiceTest {

    /**
     * Tests the roll method of the Dice class with a random value.
     * Assuming that the random value is between 1 and 10.
     */
    @Test
    void testRollWithRandomValue() {
        Dice dice = new Dice();
        dice.roll();
        int diceValue = dice.getDiceValue();
        // Assuming that the random value is between 1 and 9
        assert (diceValue >= 1 && diceValue < 10);

    }

}
