package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.java.simonsobstaclecourse.controller.GameController;
import com.java.simonsobstaclecourse.view.GameView;

import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

@SuppressWarnings("restriction")
class GameControllerTest {

    private GameController gameController;

    /**
     * Initializing the JavaFX environment before running tests.
     */
    @BeforeAll
    public static void initJavaFX() {
        // Initialize JavaFX
        new JFXPanel();
        Platform.runLater(() -> {
            // keeping a Placeholder to ensure JavaFX Toolkit is initialized
        });
    }

    /**
     * Setting up the test environment before each test method.
     */
    @BeforeEach
    void setUp() {
        // Assuming the way to load the FXML and set up the controller
        // Mock the FXMLLoader or use a testing-specific setup
        gameController = new GameController();

        // Mock the Label (welcomeText) to avoid real interactions with JavaFX components
        Label mockWelcomeText = Mockito.mock(Label.class);
        gameController.welcomeText = mockWelcomeText;
    }

    /**
     * Tests the onHelloButtonClick method of the GameController class.
     * Verifying that the welcome text is set to a specific value after clicking the button.
     */
    @Test
    void onHelloButtonClick() {
        // For simplicity, we have assumed that onHelloButtonClick() sets the welcome text to a specific value
        gameController.onHelloButtonClick();
        assertEquals("Welcome to JavaFX Application!", gameController.welcomeText.getText());
    }

    /**
     * Tests the start method of the GameController class with mocked input.
     * Simulating user input to end the game and verifies that the game is over.
     */
    @Test
    void startGameWithMockedInput() {
        // Assuming we have a way to mock the gameView and control its inputs

        // Mocking the gameView to simulate the user's input
        GameView mockGameView = mock(GameView.class);
        when(mockGameView.getCommand()).thenReturn("QUIT"); // Simulate the user entering QUIT to end the game

        // Setting up the mocked gameView in the gameController
        gameController.gameView = mockGameView;

        // Running the start method
        gameController.start();

        // Verifying that the game is over
        assertTrue(gameController.board.isGameOver());
    }

}
