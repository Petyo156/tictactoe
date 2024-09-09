package stuff.tictactoe.tictactoe.enums;

public enum Type {
    CIRCLE("O"),
    CROSS("X"),
    UNDEFINED(" ");

    private final String symbol;

    Type(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

