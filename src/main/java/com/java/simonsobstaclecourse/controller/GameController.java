package com.java.simonsobstaclecourse.controller;

import com.java.simonsobstaclecourse.model.board.Board;
import com.java.simonsobstaclecourse.model.board.Dice;
import com.java.simonsobstaclecourse.model.board.ScoreBoard;
import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameController {
    @FXML
    private GridPane gameBoard;
    @FXML
    private Label currentPlayer;


    @FXML
    private AnchorPane startWindow;
    @FXML
    private Button start;
    @FXML
    private MenuButton boardSize;
    @FXML
    private MenuButton dificultyLevel;
    @FXML
    private MenuButton numberOfPlayers;


    @FXML
    private AnchorPane playerNamesbar;
    @FXML
    private TextField p1Name;
    @FXML
    private TextField p2Name;
    @FXML
    private TextField p3Name;
    @FXML
    private TextField p4Name;
    @FXML
    private Button inputSubmit;

    @FXML
    private AnchorPane controlPanel;
    @FXML
    private Button move;
    @FXML
    private Button roll;
    @FXML
    private Label rollValue;
    @FXML
    private Button skip;

    @FXML
    private ListView<String> topScore;
    @FXML
    private VBox highScore;

    @FXML
    private Label message;


    @FXML
    void startGame(MouseEvent event) {
        switch (playerCount){
            case 4:
                p4Name.setVisible(true);
                p3Name.setVisible(true);
                p2Name.setVisible(true);
                p1Name.setVisible(true);
                break;
            case 3:
                p4Name.setVisible(false);
                p3Name.setVisible(true);
                p2Name.setVisible(true);
                p1Name.setVisible(true);
                break;
            case 2:
                p4Name.setVisible(false);
                p3Name.setVisible(false);
                p2Name.setVisible(true);
                p1Name.setVisible(true);
                break;
        }
        startWindow.setVisible(false);
        playerNamesbar.setVisible(true);
    }


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

    public Players getPlayers() {
        Players tempPlayers = new Players(playerCount);
        switch (playerCount){
            case 2:
                tempPlayers.add(new Player(1, p1Name.getText()));
                tempPlayers.add(new Player(2, p2Name.getText()));
                break;
            case 3:
                tempPlayers.add(new Player(1, p1Name.getText()));
                tempPlayers.add(new Player(2, p2Name.getText()));
                tempPlayers.add(new Player(3, p3Name.getText()));
                break;
            case 4:
                tempPlayers.add(new Player(1, p1Name.getText()));
                tempPlayers.add(new Player(2, p2Name.getText()));
                tempPlayers.add(new Player(3, p3Name.getText()));
                tempPlayers.add(new Player(4, p4Name.getText()));
        }
        return tempPlayers;
    }

    @FXML
    void submitInputValues(MouseEvent event) {
        playerNamesbar.setVisible(false);
        players = getPlayers();
        board = new Board(dice, players, difficulty, boardSizeChoice);
        gameView.updateBoard(gameBoard,board.getSquares());
        currentPlayer.setText(players.getCurrentPlayer().toString());

        controlPanel.setVisible(true);
        rollValue.setVisible(false);
        move.setVisible(false);
        skip.setVisible(false);
        currentPlayer.setVisible(true);
        gameBoard.setVisible(true);
    }
    private void initializeMenuButtons() {
        //board size
        MenuItem size3x3 = new MenuItem("3x3");
        MenuItem size5x5 = new MenuItem("5x5");
        MenuItem size7x7 = new MenuItem("7x7");


        // Set action event handlers for board size choices
        size3x3.setOnAction(event -> handleBoardSizeSelection(9));
        size5x5.setOnAction(event -> handleBoardSizeSelection(25));
        size7x7.setOnAction(event -> handleBoardSizeSelection(49));

        // Add choices to the board size menu button
        boardSize.getItems().addAll(size3x3, size5x5, size7x7);

        //Difficulty
        MenuItem easy = new MenuItem("easy");
        MenuItem normal = new MenuItem("normal");
        MenuItem hard = new MenuItem("hard");

        // Set action event handlers for difficulty choices
        easy.setOnAction(event -> handleDifficultySelection(1));
        normal.setOnAction(event -> handleDifficultySelection(2));
        hard.setOnAction(event -> handleDifficultySelection(3));

        // Add choices to the difficulty menu button
        dificultyLevel.getItems().addAll(easy, normal, hard);

        //No of Players
        //Difficulty
        MenuItem two = new MenuItem("Two");
        MenuItem three = new MenuItem("Three");
        MenuItem four = new MenuItem("Four");

        // Set action event handlers for number of players choice
        two.setOnAction(event -> handelPlayerCountSelection(2));
        three.setOnAction(event -> handelPlayerCountSelection(3));
        four.setOnAction(event -> handelPlayerCountSelection(4));

        // Add choices to the number of players menu button
        numberOfPlayers.getItems().addAll(two, three, four);
    }
    private void handleBoardSizeSelection(int size) {
        System.out.println("Selected board size: " + size);
        boardSizeChoice = size;
        // Perform actions based on the selected board size
    }
    private void handleDifficultySelection(int difficulty) {
        System.out.println("difficulty: " + difficulty);
        this.difficulty = difficulty;
        // Perform actions based on the selected board size
    }
    private void handelPlayerCountSelection(int playerCount) {
        System.out.println("Selected player count: " + playerCount);
        this.playerCount = playerCount;
        // Perform actions based on the selected board size
    }


    //Command line Interface controller implementation:
    Players players;
    Dice dice;
    Board board;
    boolean isMove;
    int boardSizeChoice = 25;
    int playerCount = 2;
    int difficulty = 2;
    GameView gameView;

    @FXML
    public void initialize(){
        initializeMenuButtons();

        gameView = new GameView();
        dice = new Dice();
        playerNamesbar.setVisible(false);
        controlPanel.setVisible(false);
        gameBoard.setVisible(false);
        highScore.setVisible(false);

    }



}