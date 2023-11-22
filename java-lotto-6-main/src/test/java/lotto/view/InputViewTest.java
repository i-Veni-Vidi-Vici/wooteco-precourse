package lotto.view;

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

    @DisplayName("로또 구입 금액 입력")
    @Test
    void getMoney() {
        System.setIn(new ByteArrayInputStream("1000" .getBytes()));

        assertThat(inputView.getMoney()).isEqualTo("1000");
    }

    @DisplayName("당첨 번호 입력")
    @Test
    void getWinningNumber() {
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6" .getBytes()));

        assertThat(inputView.getWinningNumber()).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호 입력")
    @Test
    void getBonusNumber() {
        System.setIn(new ByteArrayInputStream("7" .getBytes()));

        assertThat(inputView.getWinningNumber()).isEqualTo("7");
    }
}
