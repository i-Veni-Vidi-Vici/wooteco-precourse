package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachesTest {

    @DisplayName("코치 생성")
    @Test
    void create() {
        Coaches coaches = new Coaches(List.of("pobi", "jun", "woni"));

        assertThat(coaches.get()).isEqualTo(List.of("pobi", "jun", "woni"));
    }

    @DisplayName("이름 길이가 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void checkNameLength(String name) {
        assertThatThrownBy(() -> new Coaches(List.of(name, "123")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치의 수가 범위를 벗어날 때, 예외 처리")
    @Test
    void checkCount() {
        assertThatThrownBy(() -> new Coaches(List.of("12")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Coaches(List.of("12", "ab", "abc", "abcd", "123", "1234")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
