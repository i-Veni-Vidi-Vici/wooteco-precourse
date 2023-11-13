package christmas.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    @DisplayName("입력된 문자열을 Integer로 변환")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "20,20", "31,31"})
    void convertToNumber(String userInput, Integer convertedInput) {
        assertThat(Converter.convertToNumber(userInput)).isEqualTo(convertedInput);
    }

    @DisplayName("정수 이외의 값을 변환할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1.1", "1a"})
    void convertToNumberByNotInteger(String userInput) {
        assertThatThrownBy(() -> Converter.convertToNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 앞에 0이 있을 때(2자리 이상), 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "000000010", "0a", "00"})
    void convertToNumberByFirstZero(String userInput) {
        assertThatThrownBy(() -> Converter.convertToNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
