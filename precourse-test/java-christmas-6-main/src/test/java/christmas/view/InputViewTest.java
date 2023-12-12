package christmas.view;

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

    @DisplayName("예약 날짜 입력")
    @Test
    void getDate() {
        System.setIn(new ByteArrayInputStream("25".getBytes()));

        assertThat(inputView.getDate()).isEqualTo("25");
    }

    @DisplayName("예약 메뉴 입력")
    @Test
    void getMenu() {
        System.setIn(new ByteArrayInputStream("해산물파스타-1".getBytes()));

        assertThat(inputView.getMenu()).isEqualTo("해산물파스타-1");
    }
}
