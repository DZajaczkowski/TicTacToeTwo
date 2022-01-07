package com.example.tictactoetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeTwoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TicTacToeTwoApplication.class, args);
        Player playerCircle = new Player();
        Player playerCross = new Player();
        Game game = new Game(playerCircle, playerCross);
        new CLI(game).start();
    }

}
