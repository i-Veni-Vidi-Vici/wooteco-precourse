package lotto.constants;

public enum Symbol {
    THREE_HYPHEN("---"),
    HYPHEN("-"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    COMMA(","),
    WHITESPACE(" "),
    PRIZE_FORMAT("%,d"),
    EARNINGS_RATE_FORMAT("%,.1f");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
