package racingcar.constants;

public enum Symbol {
    HYPHEN("-"),
    EMPTY(""),
    COMMA(","),
    WHITESPACE(" "),
    COLON(":");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
