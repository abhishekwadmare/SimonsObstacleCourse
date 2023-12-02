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
        players = new ArrayList<>(2);
        players.add(new Player(1, "Abhishek"));
        players.add(new Player(2, "Lakshya"));

    }

    public void start(){
        while (!board.isGameOver()){

            board.getSquares().get(3).setPlayer(1);
            board.getSquares().get(6).setPlayer(2);

            gameView.displayBoard(board.getSquares());

            String command = gameView.getCommand().toUpperCase().trim();
            switch (command){
                case "QUIT":
                    board.setGameOver(true);
                    break;
                case "ROLL":
                    board.rollDice();
                default:
                    System.out.println("You have entered incorrect Command!");
            }
        }
        System.out.println("bye!!!");
    }

}