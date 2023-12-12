package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @DisplayName("이벤트 플래너 시작 문구 출력")
    @Test
    void printPlanner() {
        outputView.printPlanner();

        assertThat(out.toString())
                .contains("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    @DisplayName("예약 날짜 출력")
    @Test
    void printDate() {
        outputView.printDate(25);

        assertThat(out.toString())
                .contains("12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    }
    @DisplayName("할인 후 예상 결제 금액 출력")
    @Test
    void printPaymentAmount() {
        outputView.printPaymentAmount(135754);

        assertThat(out.toString())
                .contains("<할인 후 예상 결제 금액>")
                .contains("135,754원");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError() {
        outputView.printError("[ERROR] message");

        assertThat(out.toString())
                .contains("[ERROR] message");
    }
}
