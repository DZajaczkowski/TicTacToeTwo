package com.example.tictactoetwo.tictactoe;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> newGame(@RequestBody NewGameRequest newGameRequest) {
        return new ResponseEntity<>(gameService.newGame(newGameRequest),HttpStatus.CREATED);
    }

    @GetMapping("/status/{id}")
    public Game showStatus(@PathVariable long id) {
        return gameService.getGame(id);
    }

    @PostMapping("/{id}/move")
    public Game move(@RequestBody Move move, @PathVariable long id) {
        return gameService.move(move, id);
    }

}
