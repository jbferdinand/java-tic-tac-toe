package tictactoe;

import java.util.List;
import java.util.Random;

public class MediumAIPlayer extends AIPlayer {
    Random random;

    public MediumAIPlayer(String name, char symbol) {
        super(name, symbol);
        random = new Random();
    }

    @Override
    public void makeMove(Board board) {
        int[] bestMove = getWinningMove(board);
        if (bestMove == null) {
            bestMove = getRandomMove(board);
        }
        board.placeSymbol(bestMove[0], bestMove[1], symbol);
        System.out.println("Making move level \"medium\"");
    }

    private int[] getRandomMove(Board board) {
        List<int[]> availableMoves = board.getAvailableMoves();
        int randomNumber = random.nextInt(availableMoves.size());
        return availableMoves.get(randomNumber);

    }

    private int[] getWinningMove(Board board) {
        List<int[]> availableMoves = board.getAvailableMoves();
        char opponentSymbol = symbol == 'X' ? 'O' : 'X';
        char[] symbols = new char[]{symbol, opponentSymbol};
        for (char symb : symbols) {
            for (int[] move : availableMoves
            ) {
                board.placeSymbol(move[0], move[1], symb);
                if (board.isWin(symb)) {
                    board.placeSymbol(move[0], move[1], ' ');
                    return move;
                }
                board.placeSymbol(move[0], move[1], ' ');

            }
        }
        return null;
    }
}
