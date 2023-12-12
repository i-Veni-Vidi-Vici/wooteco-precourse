package menu.constants;

public enum Error {
    COACH_LENGTH_ERROR("[ERROR] 코치 이름 길이는 2~4자 이어야 입니다."),
    COACH_COUNT_ERROR("[ERROR] 코치는 2~5명 이어야 합니다."),
    COACH_DUPLICATION_ERROR("[ERROR] 코치 이름이 중복 됩니다."),
    BLANK_ERROR("[ERROR] 코치 이름이 공백으로 이루어져 있습니다."),
    WHITESPACE_ERROR("[ERROR] 코치 이름 앞 또는 뒤에 공백이 포함 됩니다."),

    MENU_COUNT_ERROR("[ERROR] 못 먹는 메뉴 개수는 2개이하 이어야 합니다."),
    MENU_DUPLICATION_ERROR("[ERROR] 못 먹는 메뉴가 중복됩니다."),
    NON_EXISTENT_MENU_ERROR("[ERROR] 못 먹는 메뉴가 존재하지 않습니다."),

    COMMA_ERROR("[ERROR] 콤마(,)를 마지막에 입력하지 마세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
