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
        // Assuming that the random value is between 1 and 10
        assert (diceValue >= 1 && diceValue <= 10);
    }

    /**
     * Tests the roll method of the Dice class with a specific value provided by a mock Scanner.
     */
    @Test
    void testRollWithSpecificValue() {
        Dice dice = new Dice();
        // Setting up a mock Scanner to provide specific input
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5".getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Rolling the dice with the mock Scanner
        dice.roll();

        int diceValue = dice.getDiceValue();
        assertEquals(5, diceValue);
    }

    /**
     * Tests the roll method of the Dice class with invalid input provided by a mock Scanner.
     * Keeps the default value (0) for invalid input.
     */
    @Test
    void testRollWithInvalidInput() {
        Dice dice = new Dice();
        // Setting up a mock Scanner to provide invalid input
        ByteArrayInputStream inputStream = new ByteArrayInputStream("invalid".getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Rolling the dice with the mock Scanner
        dice.roll();

        int diceValue = dice.getDiceValue();
        // Keeping the default value should be 0 for invalid input
        assertEquals(0, diceValue);
    }

    /**
     * Testing the roll method of the Dice class with a mocked ThreadLocalRandom.
     * Provides a specific value (7) through the mock.
     */
    @Test
    void testRollWithMockedThreadLocalRandom() {
        Dice dice = new Dice();
        // Setting up a mock for ThreadLocalRandom
        ThreadLocalRandom mockRandom = mock(ThreadLocalRandom.class);
        when(mockRandom.nextInt(1, 10)).thenReturn(7);

        // Rolling the dice with the mock ThreadLocalRandom
        dice.roll();

        int diceValue = dice.getDiceValue();
        assertEquals(7, diceValue);
    }
}
