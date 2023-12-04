package com.java.simonsobstaclecourse.view;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.model.board.Square;
import com.java.simonsobstaclecourse.model.board.Squares;

import java.util.Scanner;

public class GameView {

    public void displayBoard(Squares squares){

        for (Square square: squares) {
            System.out.print(square + " ");
        }
    }
    public void displayCurrentPlayer(Players players){
        System.out.println(players.get(players.getCurrentPlayerId()-1));
    }
    public void displayDice(int diceValue){
        System.out.println("The dice value is: " + diceValue);
    }

    public void displayInvalidMoveMessage(){
        System.out.print("Move not possible");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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

    public boolean getMoveChoice(){

        System.out.print("Do you want to move?(Y|N) : ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toUpperCase().trim();
        return choice.equals("Y") || choice.equals("YES");
    }

}
