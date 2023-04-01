package tictactoe;

public abstract class AIPlayer implements Player {

    protected String name;
    protected char symbol;

    public AIPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
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
