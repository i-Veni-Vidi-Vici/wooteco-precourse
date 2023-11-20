package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNumberTest {

    @DisplayName("3개의 숫자가 아닐 때, 예외 처리")
    @Test
    void checkSize() {
        assertThatThrownBy(() -> new UserNumber(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~9 범위를 벗어날 때, 예외 처리")
    @Test
    void checkRange() {
        assertThatThrownBy(() -> new UserNumber(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserNumber(List.of(0, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 때, 예외 처리")
    @Test
    void checkDuplication() {
        assertThatThrownBy(() -> new UserNumber(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserNumber(List.of(3, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
