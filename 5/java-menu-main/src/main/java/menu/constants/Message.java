package menu.constants;

public enum Message {
    COACHES_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INEDIBLE_MENU_INPUT("(이)가 못 먹는 메뉴를 입력해 주세요."),

    START("점심 메뉴 추천을 시작합니다."),
    RECOMMENDATIONS("메뉴 추천 결과입니다."),
    DAY_OF_THE_WEEK("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    CATEGORY("카테고리"),
    COMPLETION("추천을 완료했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
