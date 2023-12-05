package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InformationTest {
    @DisplayName("존재하지 않는 정보일 때,예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"백드, 레벨0, 로또","백엔드, 레벨0, 로또", "백엔드, 레벨1, 과자"})
    void checkFunction(String value) {
        assertThatThrownBy(() -> new Information(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
