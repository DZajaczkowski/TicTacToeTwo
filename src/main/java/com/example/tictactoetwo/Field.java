package com.example.tictactoetwo;

public enum Field {

    CIRCLE("O"), CROSS("X"), EMPTY("_");

    private final String sign;

    Field(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }

}
