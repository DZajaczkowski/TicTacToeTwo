package com.example.tictactoetwo;


import static com.example.tictactoetwo.Field.*;
import static com.example.tictactoetwo.Status.*;
import static com.example.tictactoetwo.Status.WINNER_CIRCLE;

public class Game {

    private final Board board = new Board();
    private final Player playerCircle;
    private final Player playerCross;
    private Player currentPlayer;
    private Status status = IN_PROGRESS;
    private Player winner;

    public Game(Player playerCircle, Player playerCross) {
        this.playerCircle = playerCircle;
        this.playerCross = playerCross;
        currentPlayer = playerCircle;
    }

    void move(int row, int column, Player player) {
        if (status != IN_PROGRESS)
            return;
        if (player != currentPlayer)
            return;
        if (board.get(row, column) != EMPTY) {
            return;
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
                endGame(board.get(i,0));
            if (board.get(0, i) != EMPTY && board.get(0, i) == board.get(1, i) && board.get(0, i) == board.get(2, i))
                endGame(board.get(0, i));
        }
        if (board.get(1,1) == EMPTY)
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
        }
        else if (field == CROSS) {
            status = WINNER_CROSS;
            winner = playerCross;
        }
        else
        status = DRAW;
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
