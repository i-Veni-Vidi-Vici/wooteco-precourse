package pairmatching.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

public class OutputViewTest {

    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("과정 & 미션 정보 출력")
    @Test
    void printInformation() {
        outputView.printInformation();

        assertThat(out.toString())
                .contains("#############################################")
                .contains("과정: 백엔드 | 프론트엔드")
                .contains("미션:")
                .contains("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임")
                .contains("  - 레벨2: 장바구니 | 결제 | 지하철노선도")
                .contains("  - 레벨3: ")
                .contains("  - 레벨4: 성능개선 | 배포")
                .contains("  - 레벨5: ")
                .contains("############################################");
    }

    @DisplayName("페어 매칭 결과 출력, 홀수 크루")
    @Test
    void printResultByOddCrews() {
        outputView.printResult(Arrays.asList("이브", "윌터", "보노", "제키", "리사", "덴버", "라라"));

        assertThat(out.toString())
                .contains("페어 매칭 결과입니다.")
                .contains("이브 : 윌터")
                .contains("보노 : 제키")
                .contains("리사 : 덴버 : 라라");
    }

    @DisplayName("페어 매칭 결과 출력, 짝수 크루")
    @Test
    void printResultByEvenCrews() {
        outputView.printResult(Arrays.asList("이브", "윌터", "보노", "제키", "리사", "덴버"));

        assertThat(out.toString())
                .contains("페어 매칭 결과입니다.")
                .contains("이브 : 윌터")
                .contains("보노 : 제키")
                .contains("리사 : 덴버");
    }

    @DisplayName("페어 초기화 출력")
    @Test
    void printInitialization() {
        outputView.printInitialization();

        assertThat(out.toString())
                .contains("초기화 되었습니다.");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError() {
        outputView.printError("[ERROR] message");

        assertThat(out.toString())
                .contains("[ERROR] message");
    }
}
