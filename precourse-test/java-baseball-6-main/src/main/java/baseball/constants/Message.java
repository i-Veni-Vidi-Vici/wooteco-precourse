package baseball.constants;

public enum Message {
    START_BASEBALL_GAME("숫자 야구 게임을 시작합니다."),
    THREE_NUMBER_INPUT("숫자를 입력해주세요 : "),
    RESTART_NUMBER_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    EXIT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    WHITESPACE(" "),
    EMPTY("");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
