package pairmatching.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LevelTest {

    @DisplayName("레벨이 존재하지 않을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"레벨0", "레벨", "레벨6"})
    void checkLevelExistence(String value) {
        assertThatThrownBy(() -> Level.checkLevelExistence(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("미션이 존재하지 않을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"자동차 경주", "성능", "숫자야구"})
    void checkMissionExistence(String value) {
        assertThatThrownBy(() -> Level.checkMissionExistence(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
