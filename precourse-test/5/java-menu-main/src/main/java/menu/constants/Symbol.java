package menu.constants;

public enum Symbol {
    VERTICAL_BAR("|"),
    COMMA(","),
    WHITESPACE(" "),
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
