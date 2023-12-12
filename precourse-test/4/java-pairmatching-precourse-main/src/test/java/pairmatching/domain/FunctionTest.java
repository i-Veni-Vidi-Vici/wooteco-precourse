package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {

    @DisplayName("존재하지 않는 기능일 때,예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "q"})
    void checkFunction(String value) {
        assertThatThrownBy(() -> new Function(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
