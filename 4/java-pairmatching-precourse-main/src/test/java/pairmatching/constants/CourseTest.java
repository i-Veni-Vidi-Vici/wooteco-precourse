package pairmatching.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CourseTest {
    @DisplayName("해당되지 않은 값일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"백앤드", "프론트", ""})
    void checkExistence(String value) {
        assertThatThrownBy(() -> Course.checkExistence(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
