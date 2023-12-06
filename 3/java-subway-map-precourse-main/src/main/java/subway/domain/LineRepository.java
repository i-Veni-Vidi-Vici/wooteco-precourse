package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkDuplication(line);
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        lines.remove(checkExistence(name));
    }

    private static void checkDuplication(Line line) {
        for (Line lineOne : lines) {
            if (lineOne.getName().equals(line.getName())) {
                throw new IllegalArgumentException("[ERROR] 중복된 노선 이름입니다.");
            }
        }
    }

    public static Line checkExistence(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
    }
}
