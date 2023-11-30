package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
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

    @DisplayName("게임 시작 문구 출력")
    @Test
    void printStart() {
        outputView.printStart();

        assertThat(out.toString())
                .contains("다리 건너기 게임을 시작합니다.");
    }

    @DisplayName("게임 진행 결과 출력")
    @Test
    void printMap() {
        List<List<String>> result = List.of(List.of("U", "O"), List.of("D", "O"), List.of("U", "X"));

        outputView.printMap(result);

        assertThat(out.toString())
                .contains("[ O |   | X ]")
                .contains("[   | O |   ]");
    }
    @DisplayName("게임 종료 문구 출력")
    @Test
    void printResult() {
        List<List<String>> result = List.of(List.of("U", "O"), List.of("D", "O"), List.of("U", "X"));

        outputView.printResult(result,2);

        assertThat(out.toString())
                .contains("최종 게임 결과")
                .contains("[ O |   | X ]")
                .contains("[   | O |   ]")
                .contains("게임 성공 여부: 실패")
                .contains("총 시도한 횟수: 2");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError() {
        outputView.printError("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        assertThat(out.toString())
                .contains("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
