package pairmatching.constants;

public enum Choice {
    YES("예"),
    NO("아니오");

    private final String value;

    Choice(String value) {
        this.value = value;
    }

    public static boolean checkExistence(String value) {
        if (YES.value.equals(value)) {
            return true;
        }
        if (NO.value.equals(value)) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR]");
    }
}
