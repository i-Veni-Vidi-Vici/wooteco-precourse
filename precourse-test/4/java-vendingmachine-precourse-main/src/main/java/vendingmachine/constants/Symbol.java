package vendingmachine.constants;

public enum Symbol {
    HYPHEN("-"),
    COMMA(","),
    WHITESPACE(" "),

    SEMI_COLON(";"),

    EMPTY(""),
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
