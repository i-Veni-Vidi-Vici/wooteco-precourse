package baseball.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    private static Converter converter;

    @BeforeAll
    static void beforeAll() {
        converter = new Converter();
    }

    @DisplayName("문자열을 Integer 리스트로 변환")
    @Test
    void convertToList() {
        assertThat(converter.convertToList("12345")).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @DisplayName("문자열이 정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "a", "1.0", "a1", "12 3"})
    void convertToListByNotInteger(String number) {
        assertThatThrownBy(() -> converter.convertToList(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 정수로 변환")
    @Test
    void convertToNumber() {
        assertThat(converter.convertToNumber("123")).isEqualTo(123);
    }

    @DisplayName("문자열이 정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "a", "1.0", "a1", "12 3"})
    void convertToNumberByNotInteger(String number) {
        assertThatThrownBy(() -> converter.convertToNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
