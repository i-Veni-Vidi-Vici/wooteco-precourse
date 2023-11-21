package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @DisplayName("1미만 일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void checkCount(Integer roundCount) {
        assertThatThrownBy(() -> new Round(roundCount));
    }
}
