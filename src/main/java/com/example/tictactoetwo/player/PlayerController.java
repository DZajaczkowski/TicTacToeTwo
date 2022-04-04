package com.example.tictactoetwo.player;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer() {
        return new ResponseEntity<>(playerService.newPlayer(), HttpStatus.CREATED);
    }

    @PutMapping("/nickname/{id}")
    public Player setPlayerNickname(@PathVariable long id, @RequestBody String nickname) {
        return playerService.setPlayerNickname(id, nickname);
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("/list")
    public List<Player> getPlayerList() {
        return playerService.getPlayers();
    }

}
