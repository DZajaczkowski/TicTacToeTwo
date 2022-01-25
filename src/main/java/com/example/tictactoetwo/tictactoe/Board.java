package com.example.tictactoetwo.tictactoe;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.example.tictactoetwo.tictactoe.Field.EMPTY;

public class Board {

    @Getter private final Field[][] board = new Field[3][3];

    Board() {
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = EMPTY;
        }
    }

    Field get(int row, int column) {
        return board[row][column];
    }

    void set(int row, int column, Field field) {
        board[row][column] = field;
    }

    @Override
    public String toString() {
        return Arrays.stream(board)
                .map(column -> Arrays.stream(column)
                        .map(Field::toString)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }

}
