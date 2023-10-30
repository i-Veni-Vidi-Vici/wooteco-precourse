package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Computer.createRoundCount;
import static racingcar.Computer.getInput;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CountInputTest {

    @Test
    void 음수_또는_0_입력_시_예외_처리() {

        // given
        String userInputOne = "-1";
        String userInputTwo = "0";

        // when, then
        assertThatThrownBy(() -> Validator.checkPositiveNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");

        assertThatThrownBy(() -> Validator.checkPositiveNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");
    }

    @Test
    void 문자_또는_공백_입력_시_예외_처리() {

        // given
        String userInputOne = "3pobi";
        String userInputTwo = " ";

        // when, then
        assertThatThrownBy(() -> Validator.checkPositiveNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력하세요.");

        assertThatThrownBy(() -> Validator.checkPositiveNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력하세요.");
    }

    @Test
    void 시도_횟수_출력문() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        car.move(createRoundCount(getInput("시도할 회수는 몇회인가요?")));

        // then
        assertThat(out.toString())
                .contains("시도할 회수는 몇회인가요?");

        Console.close();
    }
}
