package com.example.tictactoetwo;

import com.example.tictactoetwo.player.PlayerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PlayerControllerTest {

    @Autowired
    private PlayerController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void whenPlayerCreatedGet201() {
        post("/api/player")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    public void whenGetPlayerListGet200() {
        get("/api/player/list")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void whenGetPlayerByIdGet200() {
        if (controller.getPlayer(0) == null) post("/api/player");
        get("/api/player/0")
                .then()
                .assertThat()
                .statusCode(200);
    }

}
