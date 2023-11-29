package christmas.utility;

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

//    @DisplayName("문자열을 맵으로 변환")
//    @Test
//    void convertToMap() {
//        assertThat(converter.convertToMap("티본스테이크-1,해산물파스타-2"))
//                .isEqualTo(Map.of(T_BONE_STEAK, 1, SEAFOOD_PASTA, 2));
//    }
//    @DisplayName("문자열 (메뉴)형식이 예시와 다를 때, 예외 처리")
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "티본스테이크--1", "티본스테이크-1-1", "티본스테이크-1,,해산물파스타-2"
//    })
//    void convertToMapByNotForm(String value) {
//        assertThatThrownBy(() -> converter.convertToMap(value))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("메뉴 개수가 정수가 아닐 때, 예외 처리")
//    @ParameterizedTest
//    @ValueSource(strings = {"티본스테이크- ", "티본스테이크-", "티본스테이크-a", "티본스테이크-1.0"})
//    void convertToMapByNotInteger(String value) {
//        assertThatThrownBy(() -> converter.convertToMap(value))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("각 숫자 앞에 0이 포함될 때(2자리 이상), 예외 처리")
//    @ParameterizedTest
//    @ValueSource(strings = {"티본스테이크-01", "티본스테이크-00"})
//    void convertToMapByFirstZero(String value) {
//        assertThatThrownBy(() -> converter.convertToMap(value))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("중복 메뉴가 있을 때, 예외 처리")
//    @ParameterizedTest
//    @ValueSource(strings = {"티본스테이크-1,티본스테이크-3", "샴페인-1,티본스테이크-1,샴페인-2"})
//    void convertToMapByDuplication(String value) {
//        assertThatThrownBy(() -> converter.convertToMap(value))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("없는 메뉴일 때, 예외 처리")
//    @ParameterizedTest
//    @ValueSource(strings = {"abc-1", "티본스테이크-1,abc-1"})
//    void convertToMapByNotMenu(String value) {
//        assertThatThrownBy(() -> converter.convertToMap(value))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    @DisplayName("문자열 마지막에 콤마가 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-01,,,", "티본스테이크-01,"})
    void convertToMapByComma(String value) {
        assertThatThrownBy(() -> converter.convertToMap(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
