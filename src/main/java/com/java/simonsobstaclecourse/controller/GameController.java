package com.java.simonsobstaclecourse.controller;

import com.java.simonsobstaclecourse.model.board.Board;
import com.java.simonsobstaclecourse.model.board.Dice;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //Command line Interface controller implementation:
    Players players;
    Dice dice;
    Board board;
    GameView gameView;

    public GameController(){
        gameView = new GameView();
        dice = new Dice();
        players = gameView.getPlayers();
        board = new Board(dice, players);
    }

    public void start(){
        while (!board.isGameOver()){
            gameView.displayCurrentPlayer(players);
            gameView.displayBoard(board.getSquares());

            String command = gameView.getCommand();

            switch (command){
                case "QUIT":
                    board.setGameOver(true);
                    break;
                case "ROLL":
                    dice.roll();
                    gameView.displayDice(dice.getDiceValue());
                    if(board.isValidMove())
                        board.move(gameView.getMoveChoice());
                    else
                        gameView.displayInvalidMoveMessage();
                    players.switchPlayer();
                    break;
                default:
                    System.out.println("You have entered incorrect Command!");
            }
        }
        System.out.println("bye!!!");
    }

}