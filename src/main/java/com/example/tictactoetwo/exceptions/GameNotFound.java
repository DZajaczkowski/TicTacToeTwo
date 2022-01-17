package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Game does not exist.")
public class GameNotFound extends RuntimeException{

    public GameNotFound() {
        super();
    }

}
