package racingcar.view;

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

    @DisplayName("자동차 이름 입력")
    @Test
    void getCarName() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun" .getBytes()));

        assertThat(inputView.getCarName()).isEqualTo("pobi,woni,jun");
    }

    @DisplayName("라운드 수 입력")
    @Test
    void getRoundCount() {
        System.setIn(new ByteArrayInputStream("3" .getBytes()));

        assertThat(inputView.getRoundCount()).isEqualTo("3");
    }
}
