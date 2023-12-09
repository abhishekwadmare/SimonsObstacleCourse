package com.java.simonsobstaclecourse.view;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.model.board.Squares;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Scanner;

/**
 * The GameView class is responsible for updating the graphical representation
 * of the game board, displaying information such as the current player, dice
 * values, top players, win messages, and handling user input through the command
 * line interface.
 * 
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 *
 */
public class GameView {

    /**
     * Updates the graphical representation of the game board based on the provided
     * Squares object.
     *
     * @param gameBoard The GridPane representing the game board.
     * @param squares   The Squares object containing information about each square on the board.
     */
    public void updateBoard(GridPane gameBoard, Squares squares) {
        gameBoard.getChildren().clear();

        int gridSize = (int) Math.sqrt(squares.size());
        gameBoard.setAlignment(Pos.CENTER);
        int index = 0;
        int top = 0, bottom = gridSize - 1, left = 0, right = gridSize - 1;

        while (true) {
            String whiteText = "-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: white;";
            if (left > right) break;

            for (int i = left; i <= right; i++) {
                String colour;
                if (index % 2 == 0) {
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label;
                if (index == squares.size() - 1) {
                    label = new Label("Finish\n" + squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown brown brown transparent; -fx-border-width: 6px; -fx-background-color: #36dc1c;" + whiteText);
                    index++;
                } else if (index == 0) {
                    label = new Label("Start");
                    label.setStyle("-fx-border-color: brown transparent brown transparent; -fx-border-width: 6px; -fx-background-color: #3498db;" + whiteText);
                    index++;
                } else if (i == right) {
                    label = new Label(index + " " + squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown brown transparent transparent ; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                } else {
                    label = new Label(index + " " + squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown transparent brown transparent ; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                }

                label.setMinSize(100, 60);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, i, top);
            }
            top++;

            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                String colour;
                if (index % 2 == 0) {
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if (i == bottom) {
                    label.setStyle("-fx-border-color: transparent brown brown transparent; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                } else {
                    label.setStyle("-fx-border-color: transparent brown transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                }
                label.setMinSize(100, 60);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, right, i);
            }

            right--;

            if (left > right) break;

            for (int i = right; i >= left; i--) {
                String colour;
                if (index % 2 == 0) {
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if (i == left) {
                    label.setStyle("-fx-border-color: transparent transparent brown brown; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                } else {
                    label.setStyle("-fx-border-color: brown transparent brown transparent; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                }

                label.setMinSize(100, 60);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, i, bottom);
            }

            bottom--;

            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                String colour;
                if (index % 2 == 0) {
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if (i == top) {
                    label.setStyle("-fx-border-color: brown transparent transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                } else {
                    label.setStyle("-fx-border-color: transparent brown transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour + ";" + whiteText);
                }

                label.setMinSize(100, 60);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, left, i);
            }

            left++;
        }
    }

    /**
     * Updates the top players list on the graphical user interface.
     *
     * @param topScore       The ListView representing the top players list.
     * @param top10Players   The list of top players to be displayed.
     */
    public void updateTopPlayersList(ListView<String> topScore, List<Player> top10Players) {
        ObservableList<String> playerNames = FXCollections.observableArrayList();
        topScore.setPrefWidth(100);
        topScore.setPrefHeight(400);

        for (Player player : top10Players) {
            playerNames.add(player.getName() + " : " + player.getScore());
        }

        topScore.setItems(playerNames);
    }

    /**
     * Displays the current player on the console.
     *
     * @param players The Players object containing information about the players.
     */
    public void displayCurrentPlayer(Players players) {
        System.out.println(players.get(players.getCurrentPlayerId() - 1));
    }

    /**
     * Displays the dice value on the graphical user interface and on the console.
     *
     * @param diceValue The value rolled on the dice.
     * @param rollValue The Label representing the dice value on the GUI.
     */
    public void displayDice(int diceValue, Label rollValue) {
        rollValue.setText("Move " + diceValue + " steps");
        System.out.println("The dice value is: " + diceValue);
    }

    /**
     * Displays a win message on the graphical user interface and on the console.
     *
     * @param player  The player who won the game.
     * @param message The Label representing the win message on the GUI.
     */
    public void displayWinMessage(Player player, Label message) {
        message.setText(player + " won the game");
        message.setVisible(true);
        System.out.print(player + " won the game");
    }

    /**
     * Displays an invalid move message on the graphical user interface and on the console.
     *
     * @param message The Label representing the invalid move message on the GUI.
     */
    public void displayInvalidMoveMessage(Label message) {
        message.setText("Move not possible");
        message.setVisible(true);
        System.out.print("Move not possible");
    }

    /**
     * Retrieves a command from the user through the command line interface.
     *
     * @return The user-entered command.
     */
    public String getCommand() {
        System.out.println();
        String command;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        command = scanner.nextLine().toUpperCase().trim();
        return command;
    }

    /**
     * Retrieves information about the players from the user through the command line interface.
     *
     * @return The Players object containing information about the players.
     */
    public Players getPlayers() {
        int playerCount;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players:");
        playerCount = Integer.parseInt(scanner.next());
        Players players = new Players(playerCount);
        for (int i = 1; i <= playerCount; i++) {
            System.out.print("Enter Player " + i + " name: ");
            players.add(new Player(i, scanner.next()));
        }
        return players;
    }

    /**
     * Retrieves the player number to teleport from the user through the command line interface.
     *
     * @return The player number to teleport.
     */
    public int getToTransportPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which player do you want to teleport? Enter Player number: ");
        return scanner.nextInt();
    }
}
