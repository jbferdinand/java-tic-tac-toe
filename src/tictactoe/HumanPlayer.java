package tictactoe;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final String name;
    private final char symbol;

    HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Enter the coordinates:");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!board.isValidMove(row, col, true));

        board.placeSymbol(row, col, symbol);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
