package subway.domain;

public class Line {
    private String name;


    public Line(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 2글자 이상 이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
