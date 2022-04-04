package com.example.tictactoetwo.tictactoe;


import com.example.tictactoetwo.exceptions.FieldTaken;
import com.example.tictactoetwo.exceptions.TurnOfAnotherPlayer;
import com.example.tictactoetwo.player.Player;
import lombok.Getter;

import static com.example.tictactoetwo.tictactoe.Field.*;
import static com.example.tictactoetwo.tictactoe.Status.*;

public class Game {

    @Getter
    private final Board board = new Board();
    @Getter
    private final Player playerCircle;
    @Getter
    private final Player playerCross;
    @Getter
    private Player currentPlayer;
    @Getter
    private Status status = IN_PROGRESS;
    private Player winner;
    public long id;

    public Game(Player playerCircle, Player playerCross) {
        this.playerCircle = playerCircle;
        this.playerCross = playerCross;
        currentPlayer = playerCircle;
    }

    public void move(int row, int column, Player player) {
        if (player != currentPlayer)
            throw new TurnOfAnotherPlayer();
        if (board.get(row, column) != EMPTY) {
            throw new FieldTaken();
        }
        Field field = currentPlayer == playerCircle ? CIRCLE : CROSS;
        board.set(row, column, field);
        checkWinner();
        switchCurrentPlayer();
    }

    void switchCurrentPlayer() {
        currentPlayer = currentPlayer == playerCircle ? playerCross : playerCircle;
    }

    void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board.get(i, 0) != EMPTY && board.get(i, 0) == board.get(i, 1) && board.get(i, 0) == board.get(i, 2))
                endGame(board.get(i, 0));
            if (board.get(0, i) != EMPTY && board.get(0, i) == board.get(1, i) && board.get(0, i) == board.get(2, i))
                endGame(board.get(0, i));
        }
        if (board.get(1, 1) == EMPTY)
            return;
        if (board.get(0, 0) == board.get(1, 1) && board.get(0, 0) == board.get(2, 2))
            endGame(board.get(0, 0));
        if (board.get(0, 2) == board.get(1, 1) && board.get(0, 2) == board.get(2, 0))
            endGame(board.get(0, 2));
    }

    void endGame(Field field) {
        if (field == CIRCLE) {
            status = WINNER_CIRCLE;
            winner = playerCircle;
        } else if (field == CROSS) {
            status = WINNER_CROSS;
            winner = playerCross;
        } else
            status = DRAW;
    }

    public String currentPlayerToString() {
        return currentPlayer == playerCircle ? "Circle" : "Cross";
    }

    public String boardToString() {
        return board.toString();
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", playerCircle=" + playerCircle +
                ", playerCross=" + playerCross +
                ", currentPlayer=" + currentPlayer +
                ", status=" + status +
                ", winner=" + winner +
                '}';
    }
}
