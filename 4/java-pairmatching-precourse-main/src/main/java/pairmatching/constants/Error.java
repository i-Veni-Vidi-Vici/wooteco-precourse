package pairmatching.constants;

public enum Error {
    FILE_ERROR("[ERROR] 파일이 없습니다."),
    FUNCTION_ERROR("[ERROR] 해당 기능이 존재하지 않습니다."),
    COMMA_ERROR("[ERROR] 문자열 마지막에 콤마를 입력하지 마세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
