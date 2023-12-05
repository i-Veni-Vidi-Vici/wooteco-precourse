package pairmatching.constants;

public enum FunctionValue {
    FAIR_MATCHING("1", "1. 페어 매칭"),
    FAIR_SEARCH("2", "2. 페어 조회"),
    FAIR_INITIALIZATION("3", "3. 페어 초기화"),
    QUIT("Q", "Q. 종료");

    private final String value;
    private final String message;

    FunctionValue(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String get() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
