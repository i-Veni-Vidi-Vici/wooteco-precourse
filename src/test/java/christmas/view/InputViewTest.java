package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.Food;
import christmas.domain.ReservedDate;
import christmas.utility.Converter;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("날짜 받아오기")
    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "31"})
    void getDate(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when, then
        assertThat(InputView.getDate()).isEqualTo(userInput);

        Console.close();
    }

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
    @ValueSource(strings = {"01", "000000010", "0a","00"})
    void convertToNumberByFirstZero(String userInput) {
        assertThatThrownBy(() ->Converter.convertToNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void checkRange(Integer userInput) {
        assertThatThrownBy(() -> ReservedDate.checkRange(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴 입력 받기")
    @Test
    void getOrder() {
        // given
        System.setIn(new ByteArrayInputStream("해산물파스타-2,레드와인-1".getBytes()));

        // when, then
        assertThat(InputView.getMenu()).isEqualTo("해산물파스타-2,레드와인-1");

        Console.close();
    }

    @DisplayName("입력된 문자열을 주문메뉴 자료형으로 변환시키기")
    @Test
    void convertToOrderedMenu() {
        assertThat(Converter.convertToOrderedMenu("해산물파스타-2,레드와인-1"))
                .isEqualTo(Map.of(Food.SEAFOOD_PASTA, 2,
                        Food.RED_WINE, 1));
    }


    @DisplayName("중복되는 음식 입력할 때, 예외 처리")
    @Test
    void convertToOrderedMenuByDuplication(){
        assertThatThrownBy(() -> Converter.convertToOrderedMenu("해산물파스타-2,해산물파스타-2,레드와인-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" - 구분자의 개수가 1개가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-해산물파스타-2,레드와인-1","해산물파스타,레드와인-1"})
    void convertToOrderedMenuByWrongDelimiterCount(String userInput){
        assertThatThrownBy(() -> Converter.convertToOrderedMenu(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음식 개수 앞에 0이 입력될 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-01,레드와인-1","해산물파스타-000000001"})
    void convertToOrderedMenuByFirstZero(String userInput){
        assertThatThrownBy(() -> Converter.convertToOrderedMenu(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음식 개수가 정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-aa,레드와인-1","해산물파스타-1.1","해산물파스타-1.0"})
    void convertToOrderedMenuByNotPositiveNumber(String userInput){
        assertThatThrownBy(() -> Converter.convertToOrderedMenu(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
