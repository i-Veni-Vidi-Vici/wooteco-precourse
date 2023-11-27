package christmas.constants;

public enum Error {
    INVALID_DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
