package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Move out of board.")
public class WrongMove extends RuntimeException {

    public WrongMove() {
        super();
    }
}
