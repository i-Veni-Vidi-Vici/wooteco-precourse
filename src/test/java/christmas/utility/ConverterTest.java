package christmas.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.constants.Food;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    @DisplayName("입력된 문자열을 정수로 변환")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "20,20", "31,31"})
    void convertToNumber(String value, Integer number) {
        assertThat(Converter.convertToNumber(value)).isEqualTo(number);
    }

    @DisplayName("정수 이외의 값을 변환할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1.1", "1a"})
    void convertToNumberByNotInteger(String value) {
        assertThatThrownBy(() -> Converter.convertToNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 앞에 0이 있을 때(2자리 이상), 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "000000010", "0a", "00"})
    void convertToNumberByFirstZero(String value) {
        assertThatThrownBy(() -> Converter.convertToNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 주문메뉴 자료형으로 변환")
    @Test
    void convertToReservedMenu() {
        assertThat(Converter.convertToReservedMenu("해산물파스타-2,레드와인-1"))
                .isEqualTo(Map.of(Food.SEAFOOD_PASTA, 2,
                        Food.RED_WINE, 1));
    }

    @DisplayName("- 구분자의 개수가 1개가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-해산물파스타-2,레드와인-1", "해산물파스타,레드와인-1", "해산물파스타--1"})
    void convertToReservedMenuByWrongDelimiterCount(String value) {
        assertThatThrownBy(() -> Converter.convertToReservedMenu(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음식 개수가 정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-aa,레드와인-1", "해산물파스타-1.1", "해산물파스타-1.0"})
    void convertToReservedMenuByNotPositiveNumber(String value) {
        assertThatThrownBy(() -> Converter.convertToReservedMenu(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음식 개수 앞에 0이 입력될 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-01,레드와인-1", "해산물파스타-000000001"})
    void convertToReservedMenuByFirstZero(String value) {
        assertThatThrownBy(() -> Converter.convertToReservedMenu(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 음식이 있을 때, 예외 처리")
    @Test
    void convertToReservedMenuByDuplication() {
        assertThatThrownBy(() -> Converter.convertToReservedMenu("해산물파스타-2,해산물파스타-2,레드와인-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
