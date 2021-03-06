package com.example.tictactoetwo.player;

import com.example.tictactoetwo.exceptions.PlayerNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    List<Player> players = new ArrayList<>();

    public Player newPlayer() {
        var player = new Player();
        player.id = players.size();
        player.nickname = "guest";
        players.add(player);
        return player;
    }

    public Player setPlayerNickname(long id, String nickname) {
        getPlayer(id).setNickname(nickname);
        return getPlayer(id);
    }

    public Player getPlayer(long id) {
        return players.stream()
                .filter(player -> player.id == id)
                .findFirst()
                .orElseThrow(PlayerNotFound::new);
    }

    public List<Player> getPlayers() {
        return players;
    }

}
