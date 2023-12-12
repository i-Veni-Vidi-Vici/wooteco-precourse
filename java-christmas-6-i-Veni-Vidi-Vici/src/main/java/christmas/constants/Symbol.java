package christmas.constants;

public enum Symbol {
    WHITESPACE(" "),
    COLON(":"),
    MINUS("-"),
    HYPHEN("-"),
    COMMA(","),
    LESS_THAN_SYMBOL("<"),
    GREATER_THAN_SYMBOL(">"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    COMMA_INTEGER_FORMAT("%,d"),
    NEW_LINE("\n");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
