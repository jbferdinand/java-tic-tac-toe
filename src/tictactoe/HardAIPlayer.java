package tictactoe;

public class HardAIPlayer extends AIPlayer {
    public HardAIPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void makeMove(Board board) {
        int depth = 9 - board.getAvailableMoves().size();
        int[] bestMove = minimax(board, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        board.placeSymbol(bestMove[0], bestMove[1], getSymbol());
        System.out.println("Making move level \"hard\"");
    }

    private int[] minimax(Board board, int depth, int alpha, int beta, boolean isMaximizingPlayer) {
        if (board.isWin(getSymbol())) {
            return new int[]{0, 0, 10 - depth};
        } else if (board.isWin(getOpponentSymbol())) {
            return new int[]{0, 0, depth - 10};
        } else if (board.isDraw()) {
            return new int[]{0, 0, 0};
        }
        int[] bestMove = new int[3];
        int score;
        if (isMaximizingPlayer) {
            bestMove[2] = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isValidMove(row, col, false)) {
                        board.placeSymbol(row, col, symbol);
                        score = minimax(board, depth + 1, alpha, beta, false)[2];
                        board.placeSymbol(row, col, ' ');

                        if (score > bestMove[2]) {
                            bestMove[0] = row;
                            bestMove[1] = col;
                            bestMove[2] = score;
                        }
                        alpha = Math.max(alpha, bestMove[2]);
                        if (beta <= alpha) {
                            return bestMove;
                        }
                    }
                }
            }
        } else {
            bestMove[2] = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isValidMove(row, col, false)) {
                        board.placeSymbol(row, col, getOpponentSymbol());
                        score = minimax(board, depth + 1, alpha, beta, true)[2];
                        board.placeSymbol(row, col, ' ');

                        if (score < bestMove[2]) {
                            bestMove[0] = row;
                            bestMove[1] = col;
                            bestMove[2] = score;
                        }
                        beta = Math.min(beta, bestMove[2]);
                        if (beta <= alpha) {
                            return bestMove;
                        }
                    }
                }
            }
        }
        return bestMove;
    }

    private char getOpponentSymbol() {
        return symbol == 'X' ? 'O' : 'X';
    }
}
