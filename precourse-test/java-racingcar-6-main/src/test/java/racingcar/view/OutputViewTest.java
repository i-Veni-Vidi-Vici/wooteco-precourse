package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("실행 시작 문구 출력")
    @Test
    void printRun() {
        outputView.printRun();

        assertThat(out.toString())
                .contains("실행 결과");

    }

    @DisplayName("실행 결과 출력")
    @Test
    void printResult() {
        Map<String, String> car = new LinkedHashMap<>();
        car.put("pobi", "-");
        car.put("woni", "");
        car.put("jun", "-");

        outputView.printResult(car);

        assertThat(out.toString())
                .contains("pobi : -")
                .contains("woni : ")
                .contains("jun : -");
    }

    @DisplayName("최종 우승자 출력 -> 여러 명일 때 콤마로 구분")
    @Test
    void printWinnerByMany() {
        outputView.printWinner(List.of("pobi", "jun"));

        assertThat(out.toString())
                .contains("최종 우승자 : " + "pobi, jun");
    }

    @DisplayName("최종 우승자 출력-> 1명 ")
    @Test
    void printWinnerByOne() {
        outputView.printWinner(List.of("pobi"));

        assertThat(out.toString())
                .contains("최종 우승자 : " + "pobi");
    }
}
