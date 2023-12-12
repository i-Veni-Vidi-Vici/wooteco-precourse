package lotto.constants;

public enum Message {
    MONEY_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE("개를 구매했습니다."),
    WINNING_RESULT("당첨 통계"),
    WON("원"),
    COUNT("개"),
    EARNINGS_RATE("총 수익률은 "),
    EARNINGS_RATE_PERCENT("%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
