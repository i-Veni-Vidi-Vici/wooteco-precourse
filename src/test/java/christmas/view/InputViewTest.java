package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
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
        assertThat(InputView.convertToNumber(userInput,
                "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")).isEqualTo(convertedInput);
    }

    @DisplayName("정수 이외의 값을 변환할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1.1", "1a"})
    void convertToNumberByNotInteger(String userInput) {
        assertThatThrownBy(() -> InputView.convertToNumber(userInput,
                "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 앞에 0이 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "000000010", "0", "0a"})
    void checkZero(String userInput) {
        assertThatThrownBy(() -> InputView.checkZero(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void checkRange(Integer userInput) {
        assertThatThrownBy(() -> InputView.checkRange(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴 입력 받기")
    @Test
    void getOrder() {
        // given
        System.setIn(new ByteArrayInputStream("해산물파스타-2,레드와인-1".getBytes()));

        // when, then
        assertThat(InputView.getOrder()).isEqualTo("해산물파스타-2,레드와인-1");

        Console.close();
    }

    @DisplayName("입력 문자열을 맵으로 음식과 수량을 분리하기")
    @Test
    void convertToList() {
        assertThat(InputView.convertToMap("해산물파스타-2,레드와인-1"))
                .isEqualTo(Map.of("해산물파스타", 2,
                        "레드와인", 1));
    }

    @DisplayName("없는 메뉴 입력할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"토마토파스타", "레드와인1"})
    void checkMenu(String userInput){
        assertThatThrownBy(() -> InputView.checkMenu(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 음식 입력할 때, 예외 처리")
    @Test
    void checkDuplication(){
        assertThatThrownBy(() -> InputView.checkDuplication())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
