package com.example.tictactoetwo.tictactoe;

import com.example.tictactoetwo.player.Player;
import com.example.tictactoetwo.player.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    Game game;
    PlayerService playerService;

    GameService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Game newGame() {
        Player playerCircle = playerService.newPlayer();
        Player playerCross = playerService.newPlayer();
        game = new Game(playerCircle, playerCross);
        return game;
    }

    public Game getGame() {
        return game;
    }

    public Game move(Move move) {
        game.move(move.row, move.column, playerService.getPlayer(move.playerId));
        return game;
    }

}
