package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] board;
    private static final int BOARD_SIZE = 3;

    public Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeState();
    }


    private void initializeState() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("---------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print((board[i][j] + " "));
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public List<int[]> getAvailableMoves() {
        List<int[]> availableMoves = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (isValidMove(i, j, false)) {
                    availableMoves.add(new int[]{i, j});
                }
            }
        }
        return availableMoves;
    }

    public boolean isValidMove(int row, int col, boolean showWarning) {

        if (row >= 0 && col >= 0 && row < BOARD_SIZE && col < BOARD_SIZE && board[row][col] == ' ') {
            return true;
        } else {
            if (showWarning) {
                System.out.println("Coordinates should be from 1 to " + BOARD_SIZE + "!");
            }
            return false;
        }
    }

    public void placeSymbol(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean isWin(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (symbol == board[i][0] && symbol == board[i][1] && symbol == board[i][2]) {
                return true;
            } else if (symbol == board[0][i] && symbol == board[1][i] && symbol == board[2][i]) {
                return true;
            } else if (symbol == board[0][0] && symbol == board[1][1] && symbol == board[2][2]) {
                return true;
            } else if (symbol == board[2][0] && symbol == board[1][1] && symbol == board[0][2]) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOver() {
        return isDraw() || isWin('X') || isWin('O');
    }

    public void displayResult() {
        char[] symbols = new char[]{'X', 'O'};
        for (char symbol : symbols) {
            if (isWin(symbol)) {
                System.out.println(symbol + " wins");
                return;
            }
        }
        System.out.println("Draw");
    }
}
