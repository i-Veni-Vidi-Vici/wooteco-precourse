package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuOptionTest {

    @DisplayName("1 또는 2 이외의 값이 들어올 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3})
    void checkOption(Integer value) {
        assertThatThrownBy(() -> new MenuOption(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전달된 값이, 1 = true, 2 = false 반환 ")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void isOption(Integer value, boolean option) {
        // given
        MenuOption menuOption = new MenuOption(value);

        // when, then
        assertThat(menuOption.isOption()).isEqualTo(option);
    }
}
