package com.example.tictactoetwo.tictactoe;

import com.example.tictactoetwo.exceptions.GameFinished;
import com.example.tictactoetwo.exceptions.GameNotFound;
import com.example.tictactoetwo.exceptions.WrongMove;
import com.example.tictactoetwo.player.Player;
import com.example.tictactoetwo.player.PlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.tictactoetwo.tictactoe.Status.IN_PROGRESS;

@Service
public class GameService {

    List<Game> games = new ArrayList<>();
    PlayerService playerService;

    GameService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Game newGame(NewGameRequest newGameRequest) {
        Player playerCircle = playerService.getPlayer(newGameRequest.playerCircle);
        Player playerCross = playerService.getPlayer(newGameRequest.playerCross);
        Game game = new Game(playerCircle, playerCross);
        game.id = games.size();
        games.add(game);
        return game;
    }

    public Game getGame(long id) {
        return games.stream()
                .filter(game -> game.id == id)
                .findFirst()
                .orElseThrow(GameNotFound::new);
    }

    public Game move(Move move, long id) {
        checkMove(move, id);
        getGame(id).move(move.row, move.column, playerService.getPlayer(move.playerId));
        return getGame(id);
    }

    private void checkMove(Move move, long id) {
        if (getGame(id).getStatus() != IN_PROGRESS)
            throw new GameFinished();
        if (move.column < 0 || move.column > 2 || move.row < 0 || move.row > 2)
            throw new WrongMove();
    }

}
