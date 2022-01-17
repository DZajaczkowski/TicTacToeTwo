package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Turn of another player.")
public class TurnOfAnotherPlayer extends RuntimeException {

    public TurnOfAnotherPlayer() {
        super();
    }

}
