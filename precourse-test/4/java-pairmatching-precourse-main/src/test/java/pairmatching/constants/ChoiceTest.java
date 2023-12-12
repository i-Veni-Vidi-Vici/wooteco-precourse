package pairmatching.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ChoiceTest {
    @DisplayName("선택 예=true, 아니오=false 반환")
    @ParameterizedTest
    @CsvSource(value = {"예,true", "아니오,false"})
    void check(String value, boolean result) {
        assertThat(Choice.check(value)).isEqualTo(result);
    }

    @DisplayName("선택에 존재하지 않는 값일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"에", "아니요", ""})
    void checkByNonexistence(String value) {
        assertThatThrownBy(() -> Choice.check(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
