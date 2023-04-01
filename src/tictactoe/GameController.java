package tictactoe;

public class GameController {
    private final Board board;


    public GameController() {
        board = new Board();
    }

    public void startGame(PlayerFactory.Difficulty playerXDifficulty, PlayerFactory.Difficulty playerODifficulty) {
        Player playerX = PlayerFactory.createPlayer(playerXDifficulty, 'X');
        Player playerO = PlayerFactory.createPlayer(playerODifficulty, 'O');
        Player currentPlayer = playerX;
        while (!board.isOver()) {
            board.displayBoard();
            currentPlayer.makeMove(board);
            currentPlayer = currentPlayer == playerX ? playerO : playerX;
        }
        board.displayBoard();
        board.displayResult();
    }


}

