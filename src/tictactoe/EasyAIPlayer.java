package tictactoe;

import java.util.List;
import java.util.Random;

public class EasyAIPlayer extends AIPlayer {
    Random random;

    public EasyAIPlayer(String name, char symbol) {
        super(name, symbol);
        random = new Random();
    }

    @Override
    public void makeMove(Board board) {
        int[] randomMove = getRandomMove(board);
        board.placeSymbol(randomMove[0], randomMove[1], symbol);
        System.out.println("Making move level \"easy\"");
    }

    private int[] getRandomMove(Board board) {
        List<int[]> availableMoves = board.getAvailableMoves();
        int randomNumber = random.nextInt(availableMoves.size());
        return availableMoves.get(randomNumber);

    }
}
