/*
 * Main class for SimonsObstacleCourse application.
 * This class extends the JavaFX Application class and serves as the entry point for the application.
 *
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 */
package com.java.simonsobstaclecourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class represents the starting point of the application.
 */
public class Main extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 750);
        stage.setTitle("SimonsObstacleCourse");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point of the application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }
}
