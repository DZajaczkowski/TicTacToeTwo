package com.example.tictactoetwo;

import com.example.tictactoetwo.player.PlayerService;
import com.example.tictactoetwo.tictactoe.GameController;
import com.example.tictactoetwo.tictactoe.Move;
import com.example.tictactoetwo.tictactoe.NewGameRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GameControllerTest {

    private static boolean setUpIsDone = false;

    @Autowired
    private GameController controller;
    @Autowired
    PlayerService playerService;
    NewGameRequest newGameRequest = new NewGameRequest();
    Move move = new Move();

    @Before
    public void setUp() {
        if (setUpIsDone) return;
        playerService.newPlayer();
        playerService.newPlayer();
        setUpIsDone = true;
    }

    private void createNewGame() {
        newGameRequest.playerCircleId = 0;
        newGameRequest.playerCrossId = 1;
        controller.newGame(newGameRequest);
    }

    private void presetMove() {
        move.row = 0;
        move.column = 0;
        move.playerId = 0;
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(playerService).isNotNull();
    }

    @Test
    public void whenGameCreatedGet201() {
        newGameRequest.playerCircleId = 0;
        newGameRequest.playerCrossId = 1;
        given()
                .contentType(JSON)
                .accept(JSON)
                .body(newGameRequest)
                .when()
                .post("/api/game")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    public void whenShowGameStatusByIdGet200() {
        createNewGame();
        int id = 0;
        get("/api/game/status/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void whenFirstMoveInGameByIdGet200() {
        createNewGame();
        presetMove();
        int id = 0;
        given()
                .contentType(JSON)
                .accept(JSON)
                .body(move)
                .when()
                .post("/api/game/" + id + "/move")
                .then()
                .assertThat()
                .statusCode(200);
    }

}
