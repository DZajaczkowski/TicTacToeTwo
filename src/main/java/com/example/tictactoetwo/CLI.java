package com.example.tictactoetwo;

import com.example.tictactoetwo.tictactoe.Game;
import com.example.tictactoetwo.tictactoe.Status;

import java.util.Scanner;

public class CLI {

    Game game;
    Scanner in = new Scanner(System.in);

    CLI(Game game) {
        this.game = game;
    }

    void start() {
        while (game.getStatus() == Status.IN_PROGRESS) {
            chooseAction();
        }
    }

    void printMenu() {
        System.out.println("Turn of " + game.currentPlayerToString() + ". Choose action:");
        System.out.println(" 1. Move.");
        System.out.println(" 2. Show board.");
    }

    void chooseAction() {
        printMenu();
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                chooseMove();
                break;
            case 2:
                System.out.println(game.boardToString());
        }
    }

    void chooseMove() {
        System.out.println("Insert row and column:");
        int row = in.nextInt();
        int column = in.nextInt();
        game.move(row, column, game.getCurrentPlayer());
    }

}
