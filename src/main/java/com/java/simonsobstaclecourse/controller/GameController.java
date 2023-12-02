package com.java.simonsobstaclecourse.controller;

import com.java.simonsobstaclecourse.model.Board;
import com.java.simonsobstaclecourse.model.Player;
import com.java.simonsobstaclecourse.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class GameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    //Command line Interface controller implementation:
    ArrayList<Player> players;
    Board board;
    GameView gameView;

    public GameController(){
        setupPlayers();
        board = new Board(players);
        gameView = new GameView(board);

    }

    public void setupPlayers(){

    }

    public void start(){
        while (!board.isGameOver()){
            gameView.displayBoard();

            String command = gameView.getCommand().toUpperCase().trim();

            switch (command){
                case "QUIT":
                    board.setGameOver(true);
                    break;
                case "ROLL":
                    board.rollDice();
                default:
                    System.out.println("You have entered ");
            }
        }
    }

}