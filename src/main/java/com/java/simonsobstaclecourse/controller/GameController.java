package com.java.simonsobstaclecourse.controller;

import com.java.simonsobstaclecourse.model.board.Board;
import com.java.simonsobstaclecourse.model.board.Dice;
import com.java.simonsobstaclecourse.model.board.ScoreBoard;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameController {
    @FXML
    private Label currentPlayer;
    @FXML
    private AnchorPane controlPanel;

    @FXML
    private ListView<String> topScore;
    @FXML
    private VBox highScore;

    @FXML
    private Label message;

    @FXML
    private GridPane gameBoard;

    @FXML
    private TextField p1Name;

    @FXML
    private Button skip;

    @FXML
    private TextField p2Name;

    @FXML
    private Button inputSubmit;

    @FXML
    private Button move;

    @FXML
    private Button roll;

    @FXML
    private Label rollValue;

    @FXML
    void move(MouseEvent event) {
        board.handelObstacle();
        if(board.isGameWon()){
            players.getCurrentPlayer().increaseScore(dice.getDiceValue());
            board.getScoreBoard().addPlayerToTopList(players.getCurrentPlayer());
            gameView.displayWinMessage(players.getCurrentPlayer(), message);
            gameView.updateBoard(gameBoard,board.getSquares());
            gameView.updateTopPlayersList(topScore, board.getScoreBoard().getTop10Players());
            highScore.setVisible(true);
            controlPanel.setVisible(false);
            return;
        }
        players.switchPlayer(currentPlayer);
        roll.setVisible(true);
        rollValue.setVisible(false);
        move.setVisible(false);
        skip.setVisible(false);
        gameView.updateBoard(gameBoard,board.getSquares());
        message.setVisible(false);
        players.getCurrentPlayer().increaseScore(dice.getDiceValue());
    }

    @FXML
    void skip(MouseEvent event) {
        players.switchPlayer(currentPlayer);
        roll.setVisible(true);
        rollValue.setVisible(false);
        move.setVisible(false);
        skip.setVisible(false);
        message.setVisible(false);
    }

    @FXML
    void roll(MouseEvent event) {
        dice.roll();
        gameView.displayDice(dice.getDiceValue(), rollValue);
        rollValue.setVisible(true);
        if(!board.isValidMove()){
            gameView.displayInvalidMoveMessage(message);
            move.setVisible(false);
            skip.setVisible(true);
        } else {
            move.setVisible(true);
            skip.setVisible(true);
        }

        rollValue.setVisible(true);
        roll.setVisible(false);
    }

    @FXML
    void submitInputValues(MouseEvent event) {
        p1Name.setVisible(false);
        p2Name.setVisible(false);
        inputSubmit.setVisible(false);
        players.add(new Player(1, p1Name.getText()));
        players.add(new Player(2, p2Name.getText()));
        board = new Board(dice, players);
        gameView.updateBoard(gameBoard,board.getSquares());
        currentPlayer.setText(players.getCurrentPlayer().toString());
        currentPlayer.setVisible(true);
        roll.setVisible(true);
        gameBoard.setVisible(true);
    }

    //Command line Interface controller implementation:
    Players players;
    Dice dice;
    Board board;
    boolean isMove;
    GameView gameView;

    @FXML
    public void initialize(){
        gameView = new GameView();
        dice = new Dice();
        players = new Players(2);
        roll.setVisible(false);
        move.setVisible(false);
        skip.setVisible(false);
        gameBoard.setVisible(false);
        highScore.setVisible(false);
    }

}