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
    public ResponseEntity<Game> newGame() {
        return new ResponseEntity<>(gameService.newGame(),HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public Game showStatus() {
        return gameService.getGame();
    }

    @PostMapping("/move")
    public Game move(@RequestBody Move move) {
        return gameService.move(move);
    }

//    @GetMapping("")
//    public void temp2() {
//
//    }
//
//    @GetMapping("")
//    public void temp3() {
//
//    }

}
