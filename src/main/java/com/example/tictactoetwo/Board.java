package com.example.tictactoetwo;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.tictactoetwo.Field.EMPTY;

public class Board {

    private final Field[][] board = new Field[3][3];

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
        String boardString = Arrays.stream(board)
                .map(column -> {
                    return Arrays.stream(column)
                            .map(Field::toString)
                            .collect(Collectors.joining());
                }).collect(Collectors.joining());
        return "Board{" +
                "board=" + boardString +
                '}';
    }
}
