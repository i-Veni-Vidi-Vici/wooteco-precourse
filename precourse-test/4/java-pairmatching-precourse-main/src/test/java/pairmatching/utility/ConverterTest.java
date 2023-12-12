package pairmatching.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
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

    @DisplayName("문자열을 리스트로 변환")
    @Test
    void convertToList() {
        assertThat(converter.convertToList("1, 2, 3")).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("문자열 마지막에 콤마가 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,,,", "1,2,3,"})
    void convertToListByComma(String value) {
        assertThatThrownBy(() -> converter.convertToList(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
