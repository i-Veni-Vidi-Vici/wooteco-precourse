package christmas.constants;

public enum Condition {
    TRUE(true),
    FALSE(false);

    private final boolean condition;

    Condition(boolean condition) {
        this.condition = condition;
    }

    public boolean get() {
        return condition;
    }
}
