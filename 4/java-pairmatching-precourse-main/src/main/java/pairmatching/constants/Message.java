package pairmatching.constants;

public enum Message {
    FUNCTION_INPUT("기능을 선택하세요."),
    INFORMATION_INPUT("과정, 레벨, 미션을 선택하세요."),
    INFORMATION_FORM_INPUT("ex) 백엔드, 레벨1, 자동차경주"),
    NEW_MATCHING_INPUT("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),
    YES_OR_NO_INPUT("네 | 아니오"),

    ABSOLUTE_ROUTE("C:\\i_Veni_Vidi_Vici\\precourse-test\\4\\java-pairmatching-precourse-main\\src\\main\\resources\\"),
    FILE_NAME("-crew.md"),
    BACKEND_FILE_NAME("backend"),
    FRONTEND_FILE_NAME("frontend"),

    HASH("#############################################"),
    COURSE("과정: 백엔드 | 프론트엔드"),
    MISSION("미션:"),
    LEVEL_ONE("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임"),
    LEVEL_TWO("  - 레벨2: 장바구니 | 결제 | 지하철노선도"),
    LEVEL_THREE("  - 레벨3: "),
    LEVEL_FOUR("  - 레벨4: 성능개선 | 배포"),
    LEVEL_FIVE("  - 레벨5: "),

    PAIR_RESULT("페어 매칭 결과입니다."),
    NOTHING("매칭 이력이 없습니다."),
    INITIALIZATION("초기화 되었습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
