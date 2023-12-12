package pairmatching.constants;

public enum Error {
    FILE_ERROR("[ERROR] 파일이 없습니다."),
    FUNCTION_ERROR("[ERROR] 해당 기능이 존재하지 않습니다."),
    COMMA_ERROR("[ERROR] 문자열 마지막에 콤마를 입력하지 마세요."),

    LEVEL_ERROR("[ERROR] 존재하지 않는 레벨입니다."),
    MISSION_ERROR("[ERROR] 존재하지 않는 미션입니다."),
    COURSE_ERROR("[ERROR] 존재하지 않는 과정입니다."),
    CHOICE_ERROR("[ERROR] 존재하지 않는 선택입니다.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
