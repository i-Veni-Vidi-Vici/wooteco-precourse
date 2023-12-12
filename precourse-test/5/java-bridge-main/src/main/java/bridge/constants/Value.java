package bridge.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    FIRST_INDEX(0),

    SECOND_INDEX(1),
    INITIAL_ONE(1),
    ONE_LENGTH(1),

    TWO_LENGTH(2),
    MIN_LENGTH(3),
    MAX_LENGTH(20),
    ASCII_ZERO(48);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
