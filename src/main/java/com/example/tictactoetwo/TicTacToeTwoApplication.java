package com.example.tictactoetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeTwoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TicTacToeTwoApplication.class, args);
        Player playerCircle = new Player();
        Player playerCross = new Player();
        Game game = new Game(playerCircle, playerCross);
        System.out.println(game);
        game.move(0,0,playerCircle);
        System.out.println(game);
        game.move(1,0,playerCross);
        System.out.println(game);
        game.move(1,1,playerCircle);
        System.out.println(game);
        game.move(2,0,playerCross);
        System.out.println(game);
        game.move(2,2,playerCircle);
        System.out.println(game);
        game.move(2,1,playerCross);
        System.out.println(game);
        game.move(0,2,playerCircle);
        System.out.println(game);
    }
}
