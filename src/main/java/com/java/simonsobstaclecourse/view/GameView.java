package com.java.simonsobstaclecourse.view;

import com.java.simonsobstaclecourse.model.Board;
import com.java.simonsobstaclecourse.model.Square;
import com.java.simonsobstaclecourse.model.Squares;

import java.util.Scanner;

public class GameView {

    Board board;
    String command;
    public GameView(Board board) {
        this.board = board;
    }

    public void displayBoard(Squares squares){
        for (Square square: squares) {
            System.out.print(square + " ");
        }
    }

    public String getCommand() {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter command: ");
        command = sc.nextLine();
        return command;
    }


}
