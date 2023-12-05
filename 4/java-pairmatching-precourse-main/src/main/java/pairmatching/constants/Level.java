package pairmatching.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;

    private final List<String> mission;

    Level(String name, List<String> mission) {
        this.name = name;
        this.mission = mission;
    }

    public static void checkLevelExistence(String name) {
        for (Level level : Level.values()) {
            if (level.name.equals(name)) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR]");
    }

    public static void checkMissionExistence(String name) {
        for (Level level : Level.values()) {
            if (level.mission.contains(name)) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR]");
    }
}
