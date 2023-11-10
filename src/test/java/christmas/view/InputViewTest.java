package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
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
        // given
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when, then
        assertThat(InputView.getDate()).isEqualTo(userInput);

        Console.close();
    }

    @DisplayName("입력된 문자열을 Integer로 변환")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "20,20", "31,31"})
    void convertToNumber(String userInput, Integer convertedInput) {
        assertThat(InputView.convertToNumber(userInput)).isEqualTo(convertedInput);
    }

    @DisplayName("정수 이외의 값을 입력할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1.1", "1a"})
    void checkNumber(String userInput) {
        assertThatThrownBy(() -> InputView.checkNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void checkRange(Integer userInput) {
        assertThatThrownBy(() -> InputView.checkRange(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 앞에 0이 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "000000010", "0", "0a"})
    void checkZero(String userInput) {
        assertThatThrownBy(() -> InputView.checkZero(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
