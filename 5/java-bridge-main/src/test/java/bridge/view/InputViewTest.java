package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("다리 길이 입력")
    @Test
    void getLength() {
        System.setIn(new ByteArrayInputStream("10".getBytes()));

        assertThat(inputView.getLength()).isEqualTo("10");
    }

    @DisplayName("이동할 칸 입력")
    @Test
    void getDirection() {
        System.setIn(new ByteArrayInputStream("U".getBytes()));

        assertThat(inputView.getDirection()).isEqualTo("U");
    }

    @DisplayName("재시작/종료 여부 입력")
    @Test
    void getRetry() {
        System.setIn(new ByteArrayInputStream("R".getBytes()));

        assertThat(inputView.getRetry()).isEqualTo("R");
    }
}
