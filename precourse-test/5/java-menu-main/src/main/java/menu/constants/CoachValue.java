package menu.constants;

public enum CoachValue {
    MIN_NAME_LENGTH(2),
    MAX_NAME_LENGTH(4),

    MIN_COACH_COUNT(2),
    MAX_COACH_COUNT(5);

    private final Integer coachValue;

    CoachValue(Integer coachValue) {
        this.coachValue = coachValue;
    }

    public Integer get() {
        return coachValue;
    }
}
