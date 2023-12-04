package com.java.simonsobstaclecourse.view;

import com.java.simonsobstaclecourse.model.player.Player;
import com.java.simonsobstaclecourse.model.player.Players;
import com.java.simonsobstaclecourse.model.board.Squares;

import java.util.Scanner;

public class GameView {

    public void displayBoard(Squares squares){
        for(int i = 0; i < squares.size(); i++){
            if(i == 0)
                System.out.print("[Start] ");
            else if (i == squares.size()-1)
                System.out.println(" [Finish]");
            else
                System.out.print(squares.get(i) + " ");
        }
    }
    public void displayCurrentPlayer(Players players){
        System.out.println(players.get(players.getCurrentPlayerId()-1));
    }
    public void displayDice(int diceValue){
        System.out.println("The dice value is: " + diceValue);
    }

    public void displayWinMessage(Player player){
        System.out.print(player + "won the game");
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
