package racingcar.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    private static Converter converter;

    @BeforeAll
    static void beforeAll(){
        converter = new Converter();
    }

    @DisplayName("문자열을 Map으로 변환")
    @Test
    void convertToMap() {
        assertThat(converter.convertToMap("pobi,woni,jun"))
                .isEqualTo(Map.of("pobi", "", "woni", "", "jun", ""));
    }

    @DisplayName("앞 뒤 공백 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" pobi,a", "woni ,a", "a, jun "})
    void convertToMapByWhitespace(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 문자열일 때, 예외 처리")
    @Test
    void convertToMapByDuplication() {
        assertThatThrownBy(() -> converter.convertToMap("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 Integer로 변환")
    @Test
    void convertToNumber() {
        assertThat(converter.convertToNumber("3")).isEqualTo(3);
    }

    @DisplayName("정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "a", "1.0"})
    void convertToNumberByNotInteger(String value) {
        assertThatThrownBy(() -> converter.convertToNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 앞에 0이 포함될 때(2자리 이상), 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "00", "000005"})
    void convertToNumberByFirstZero(String value) {
        assertThatThrownBy(() -> converter.convertToNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
