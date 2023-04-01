package tictactoe;

public class PlayerFactory {
    public enum Difficulty {
        HUMAN,
        EASY,
        MEDIUM,
        HARD
    }

    public static Player createPlayer(Difficulty difficulty, char symbol) {
        return switch (difficulty) {
            case HUMAN -> new HumanPlayer("Human", symbol);
            case EASY -> new EasyAIPlayer("Easy AI", symbol);
            case MEDIUM -> new MediumAIPlayer("Medium AI", symbol);
            case HARD -> new HardAIPlayer("Hard AI", symbol);
        };
    }
}