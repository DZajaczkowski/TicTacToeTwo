//package com.example.tictactoetwo;
//
//import com.example.tictactoetwo.player.Player;
//import com.example.tictactoetwo.player.PlayerController;
//import com.example.tictactoetwo.tictactoe.GameController;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.awt.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TicTacToeTwoApplication.class)
//public class TicTacToeTwoBootstrapLiveTest {
//
//    @LocalServerPort
//    int definedServerPort = 8080;
//
//    @Autowired
//    private PlayerController playerController;
//
//    WebTestClient playerTestClient = WebTestClient.bindToController(playerController).build();
//
//    @Test
//    void test() {
//        this.playerTestClient
//                .post()
//                .uri("/api/player")
//                .exchange()
//                .expectStatus()
//                .is2xxSuccessful();
//
//    }
//
//}
