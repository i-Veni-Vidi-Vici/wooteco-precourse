package lotto.constants;

public enum ERROR {
    LOTTO_NUMBER_SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자 여야 합니다."),
    LOTTO_DUPLICATION_ERROR("[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    RANGE_ERROR("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    THOUSAND_ERROR("[ERROR] 1000단위의 금액이여야 합니다."),
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 당첨 번호와 중복된 숫자 입니다."),
    NOT_INTEGER_ERROR("[ERROR] 정수가 아닙니다."),
    FIRST_ZERO_ERROR("[ERROR] 숫자 앞에 0이 존재합니다."),
    COMMA_ERROR("[ERROR] 마지막에 콤마가 존재합니다.");

    private final String error;

    ERROR(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
