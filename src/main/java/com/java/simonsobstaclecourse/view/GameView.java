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

public class GameView {

    public void updateBoard(GridPane gameBoard, Squares squares){

        gameBoard.getChildren().clear();

        // Set up the grid
        int gridSize = (int)Math.sqrt(squares.size());
        gameBoard.setAlignment(Pos.CENTER);
        int index = 0;
        int top = 0,
                bottom = gridSize - 1,
                left = 0,
                right = gridSize - 1;

        while (true)
        {
            String whiteText = "-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: white;";
            if (left > right)
                break;

            // print top row
            for (int i = left; i <= right; i++){
                String colour;
                if(index%2 == 0){
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label;
                if(index == squares.size()-1){
                    label = new Label("Finish\n"+squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown brown brown transparent; -fx-border-width: 6px; -fx-background-color: #36dc1c;" + whiteText);
                    index++;
                } else if(index == 0){
                    label = new Label("Start");
                    label.setStyle("-fx-border-color: brown transparent brown transparent; -fx-border-width: 6px; -fx-background-color: #3498db;" + whiteText);
                    index++;
                } else if (i == right){
                    label = new Label(index + " " + squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown brown transparent transparent ; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                }else {
                    label = new Label(index + " " + squares.get(index++).toString());
                    label.setStyle("-fx-border-color: brown transparent brown transparent ; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                }

                label.setMinSize(100, 75);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, i, top);
            }
            top++;

            if (top > bottom)
                break;

            // print right column
            for (int i = top; i <= bottom; i++){
                String colour;
                if(index%2 == 0){
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if(i == bottom){
                    label.setStyle("-fx-border-color: transparent brown brown transparent; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                } else {
                    label.setStyle("-fx-border-color: transparent brown transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                }
                label.setMinSize(100, 75);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, right, i);
            }

            right--;

            if (left > right)
                break;

            // print bottom row
            for (int i = right; i >= left; i--){
                String colour;
                if(index%2 == 0){
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if(i == left){
                    label.setStyle("-fx-border-color: transparent transparent brown brown; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                } else {
                    label.setStyle("-fx-border-color: brown transparent brown transparent; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                }

                label.setMinSize(100, 75);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, i, bottom);
            }

            bottom--;

            if (top > bottom)
                break;

            // print left column
            for (int i = bottom; i >= top; i--){
                String colour;
                if(index%2 == 0){
                    colour = "#27c9b8";
                } else {
                    colour = "#3f7b50";
                }
                Label label = new Label(index + " " + squares.get(index++).toString());
                if(i == top){
                    label.setStyle("-fx-border-color: brown transparent transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                } else {
                    label.setStyle("-fx-border-color: transparent brown transparent brown; -fx-border-width: 6px; -fx-background-color: " + colour +";"  + whiteText);
                }

                label.setMinSize(100, 75);
                label.setAlignment(Pos.CENTER);
                gameBoard.add(label, left, i);
            }

            left++;
        }

    }

    public void updateTopPlayersList(ListView<String> topScore, List<Player> top10Players) {
        ObservableList<String> playerNames = FXCollections.observableArrayList();
//        topScore.setAlignment(Pos.CENTER);

        topScore.setPrefWidth(100);
        topScore.setPrefHeight(400);

        // Convert the list to strings and add them to the ObservableList
        for (Player player : top10Players) {
            playerNames.add(player.getName() + " : " + player.getScore());
        }

        // Set the ObservableList to the ListView
        topScore.setItems(playerNames);
    }
    public void displayCurrentPlayer(Players players){
        System.out.println(players.get(players.getCurrentPlayerId()-1));
    }
    public void displayDice(int diceValue, Label rollValue){
        rollValue.setText("Move " + diceValue +" steps");
        System.out.println("The dice value is: " + diceValue);
    }

    public void displayWinMessage(Player player, Label message){
        message.setText(player + " won the game");
        message.setVisible(true);
        System.out.print(player + " won the game");
    }

    public void displayInvalidMoveMessage(Label message){
        message.setText("Move not possible");
        message.setVisible(true);
        System.out.print("Move not possible");
    }

    public String getCommand() {
        System.out.println();
        String command;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        command = scanner.nextLine().toUpperCase().trim();
        return command;
    }
    public Players getPlayers(){
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

    public int getToTransportPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("which player do you want teleport, Enter Player number?");
        return scanner.nextInt();
    }

}
