package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("날짜 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "31"})
    void getDate(String userInput) {
        // given

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when, then
        assertThat(inputView.getDate()).isEqualTo(userInput);

        Console.close();
    }

    @DisplayName("주문 메뉴 입력 받기")
    @Test
    void getOrder() {
        System.setIn(new ByteArrayInputStream("해산물파스타-2,레드와인-1".getBytes()));

        // when, then
        assertThat(inputView.getMenu()).isEqualTo("해산물파스타-2,레드와인-1");

        Console.close();
    }
}
