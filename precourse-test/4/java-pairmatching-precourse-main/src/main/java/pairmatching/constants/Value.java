package pairmatching.constants;

public enum Value {
    INITIAL_ZERO(0),

    REMAINDER_ZERO(0),
    REMAINDER_ONE(1),

    FIRST_INDEX(0),
    SECOND_INDEX(1),
    THIRD_INDEX(2),

    TWO(2),
    THREE(3);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
