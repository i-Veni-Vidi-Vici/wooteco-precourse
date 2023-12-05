package pairmatching.constants;

public enum Symbol {
    COMMA(","),
    WHITESPACE(" "),
    COLON(":"),
    EMPTY("");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
