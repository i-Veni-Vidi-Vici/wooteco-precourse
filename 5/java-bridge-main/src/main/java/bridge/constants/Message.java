package bridge.constants;

public enum Message {
    BRIDGE_LENGTH_INPUT("다리의 길이를 입력해주세요."),
    DIRECTION_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    START_GAME("다리 건너기 게임을 시작합니다."),
    RESULT("최종 게임 결과"),
    SUCCESS_RESULT("게임 성공 여부: "),
    RETRY_COUNT("총 시도한 횟수: "),

    SUCCESS("성공"),
    FAILURE("실패"),

    RIGHT("O"),
    WRONG("X"),

    UPPER_BRIDGE("U"),
    BELOW_BRIDGE("D"),

    RETRY("R"),
    EXIT("Q");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
