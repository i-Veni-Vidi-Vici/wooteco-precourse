package vendingmachine.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @DisplayName("문자열을 Integer로 변환")
    @Test
    void convertToNumber() {
        assertThat(converter.convertToNumber("1000")).isEqualTo(1000);
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

    @DisplayName("문자열을 맵으로 변환")
    @Test
    void convertToMap() {
        Map<String, List<Integer>> products = new HashMap<>();
        products.put("콜라", Arrays.asList(1500, 20));
        products.put("사이다", Arrays.asList(1000, 10));

        assertThat(converter.convertToMap("[콜라,1500,20];[사이다,1000,10]"))
                .isEqualTo(products);
    }

    @DisplayName("문자열 형식이 예시와 다를 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {
            "[콜라,,1500,20]", "콜라,1500,20", "[콜라,1500,20];;[사이다,1000,10]"
    })
    void convertToMapByNotForm(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("key가 중복될 때, 예외 처리")
    @Test
    void convertToMapByDuplication() {
        assertThatThrownBy(() -> converter.convertToMap("[콜라,1500,20];[콜라,1000,10]"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("key가 공백일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"[  ,1500,20]", "[  ,1500,20]"})
    void convertToMapByBlank(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("value 마지막에 콤마가 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20,]", "[콜라,1500,20,,]"})
    void convertToMapByComma(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 마지막에 세미콜론(;)이 있을 때")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];", "[콜라,1500,20];;"})
    void convertToMapBySemiColon(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 1개이상 없을 때")
    @Test
    void convertToMapByNothing() {
        assertThatThrownBy(() -> converter.convertToMap(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대괄호가 앞 뒤에 존재하지 않으면, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20", "콜라,1500,20]","콜라,1500,20"})
    void convertToMapByNonexistenceSquareBracket(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대괄호가 한쌍 이외에 존재할 때 , 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"[[콜라,1500,20]", "[콜라,1500,20]]", "[콜라],1500,20]","[[콜라,1500,20]]"})
    void convertToMapByManySquareBracket(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
