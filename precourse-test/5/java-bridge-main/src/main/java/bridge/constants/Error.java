package bridge.constants;

public enum Error {
    INVALID_MOVE_ERROR("[ERROR] U 또는 D를 입력해 주세요."),
    INVALID_RETRY_ERROR("[ERROR] R 또는 Q를 입력해 주세요."),
    RANGE_ERROR("[ERROR] 3 이상 20이하의 숫자를 입력해 주세요."),
    NUMBER_ERROR("[ERROR] 숫자만 입력해 주세요."),
    FIRST_ZERO_ERROR("[ERROR] 숫자 앞에 0을 입력하지 마세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
