package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Player does not exist.")
public class PlayerNotFound extends RuntimeException {

    public PlayerNotFound() {
        super();
    }
}
