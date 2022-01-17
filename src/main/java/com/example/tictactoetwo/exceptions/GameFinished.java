package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Game is finished.")
public class GameFinished extends RuntimeException {

    public GameFinished() {
        super();
    }

}
