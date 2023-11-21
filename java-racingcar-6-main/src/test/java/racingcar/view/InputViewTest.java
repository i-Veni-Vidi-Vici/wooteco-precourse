package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("자동차 이름 입력")
    @Test
    void getCarName() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("pobi,woni,jun" .getBytes()));

        assertThat(inputView.getCarName()).isEqualTo("pobi,woni,jun");

        Console.close();
    }

    @DisplayName("라운드 수 입력")
    @Test
    void getRoundCount() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("3" .getBytes()));

        assertThat(inputView.getCarName()).isEqualTo("3");

        Console.close();
    }
}
