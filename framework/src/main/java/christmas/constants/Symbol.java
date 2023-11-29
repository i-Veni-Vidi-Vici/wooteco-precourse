package christmas.constants;

public enum Symbol {
    MINUS("-"),
    HYPHEN("-"),
    COMMA(","),
    WHITESPACE(" "),
    COLON(":"),

    MONEY_FORMAT("%,d"),

    LESS_THAN_SYMBOL("<"),
    GREATER_THAN_SYMBOL(">"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    EARNINGS_RATE_FORMAT("%,.1f"),
    NEW_LINE("\n"),

;

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
