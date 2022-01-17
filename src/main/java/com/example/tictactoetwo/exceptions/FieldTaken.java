package com.example.tictactoetwo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Field is already taken.")
public class FieldTaken extends RuntimeException {

    public FieldTaken() {
        super();
    }

}
