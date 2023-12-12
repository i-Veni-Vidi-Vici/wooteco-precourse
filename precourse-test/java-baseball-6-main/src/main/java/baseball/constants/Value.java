package baseball.constants;

public enum Value {
    ZERO(0),
    INITIAL_ZERO(0),
    FIRST_INDEX(0),

    MIN_NUMBER(1),
    RESTART_NUMBER(1),

    EXIT_NUMBER(2),

    THREE_STRIKE(3),
    NUMBERS_SIZE(3),

    MAX_NUMBER(9);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
