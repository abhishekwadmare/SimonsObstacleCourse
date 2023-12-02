package com.java.simonsobstaclecourse.view;

import com.java.simonsobstaclecourse.model.Board;

import java.util.Scanner;

public class GameView {

    Board board;
    String command;
    public GameView(Board board) {
        this.board = board;
    }

    public void displayBoard(){
        //Implement Display function for the Board
    }

    public String getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter command: ");
        command = sc.nextLine();
        return command;
    }


}
