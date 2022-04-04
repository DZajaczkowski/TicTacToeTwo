package com.example.tictactoetwo.tictactoe;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Game newGame(@RequestBody NewGameRequest newGameRequest) {
        return gameService.newGame(newGameRequest);
    }

    @GetMapping("/status/{id}")
    public Game showStatus(@PathVariable long id) {
        return gameService.getGame(id);
    }

    @PostMapping("/{id}/move")
    public Game move(@RequestBody Move move, @PathVariable long id) {
        return gameService.move(move, id);
    }

    @GetMapping("/list")
    public List<Game> showGameList() {
        return gameService.getGames();
    }

    @GetMapping("/list/{playerId}")
    public List<Game> showGameListWithPlayer(@PathVariable long playerId) {
        return gameService.games.stream()
                .filter(game -> game.getPlayerCircle().id == playerId || game.getPlayerCross().id == playerId)
                .collect(Collectors.toList());
    }

    @GetMapping("/list/{playerId}/won")
    public List<Game> showWonGameListWithPlayer(@PathVariable long playerId) {
        return gameService.games.stream()
                .filter(game -> game.getPlayerCircle().id == playerId && game.getStatus() == Status.WINNER_CIRCLE)
                .filter(game -> game.getPlayerCross().id == playerId && game.getStatus() == Status.WINNER_CROSS)
                .collect(Collectors.toList());
    }

    @GetMapping("/list/{playerId}/lost")
    public List<Game> showLostGameListWithPlayer(@PathVariable long playerId) {
        return gameService.games.stream()
                .filter(game -> game.getPlayerCircle().id == playerId && game.getStatus() == Status.WINNER_CROSS)
                .filter(game -> game.getPlayerCross().id == playerId && game.getStatus() == Status.WINNER_CIRCLE)
                .collect(Collectors.toList());
    }

    @GetMapping("/list/{playerId}/draw")
    public List<Game> showDrawGameListWithPlayer(@PathVariable long playerId) {
        return gameService.games.stream()
                .filter(game -> game.getPlayerCircle().id == playerId || game.getPlayerCross().id == playerId)
                .filter(game -> game.getStatus() == Status.DRAW)
                .collect(Collectors.toList());
    }

    @GetMapping("/list/{playerId}/current")
    public List<Game> showCurrentGameListWithPlayer(@PathVariable long playerId) {
        return gameService.games.stream()
                .filter(game -> game.getPlayerCircle().id == playerId || game.getPlayerCross().id == playerId)
                .filter(game -> game.getStatus() == Status.IN_PROGRESS)
                .collect(Collectors.toList());
    }

}
