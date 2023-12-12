package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @DisplayName("서로 다른 3자리수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void getThreeNumber(String number) {
        System.setIn(new ByteArrayInputStream(number.getBytes()));

        assertThat(inputView.getThreeNumber()).isEqualTo(number);
    }

    @DisplayName("게임 종료 후 재시작/종료 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void getRestartNumber(String number) {
        System.setIn(new ByteArrayInputStream(number.getBytes()));

        assertThat(inputView.getRestartNumber()).isEqualTo(number);
    }
}
