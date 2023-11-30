package bridge.constants;

public enum Symbol {
    WHITESPACE(" "),
    VERTICAL_BAR("|"),
    LEFT_SQUARE_BRACKET("["),
    RIGHT_SQUARE_BRACKET("]");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
