package com.example.tictactoetwo.player;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player createPlayer() {
        return playerService.newPlayer();
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
