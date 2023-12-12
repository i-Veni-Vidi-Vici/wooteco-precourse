package menu.constants;

public enum Value {
    INITIAL_ZERO(0),
    FIRST_INDEX(0),

    ONE(1),
    MAX_MENU_COUNT(2);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
