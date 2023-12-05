package pairmatching.constants;

import static pairmatching.constants.Error.CHOICE_ERROR;

public enum Choice {
    YES("예"),
    NO("아니오");

    private final String value;

    Choice(String value) {
        this.value = value;
    }

    public static boolean check(String value) {
        if (YES.value.equals(value)) {
            return true;
        }
        if (NO.value.equals(value)) {
            return false;
        }

        throw new IllegalArgumentException(CHOICE_ERROR.getMessage());
    }
}
