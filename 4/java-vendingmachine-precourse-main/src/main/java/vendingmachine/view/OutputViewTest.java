package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Change;

public class OutputViewTest {

    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("자판기 보유 동전 출력")
    @Test
    void printCoin() {
        Change change = new Change(450);

        outputView.printCoin(change.getCoins());

        assertThat(out.toString())
                .contains("자판기가 보유한 동전")
                .contains("500원 - 0개")
                .contains("100원 - 4개")
                .contains("50원 - 1개")
                .contains("10원 - 0개");
    }

    @DisplayName("자판기에 투입된 현재 금액 출력")
    @Test
    void printMoney() {
        outputView.printMoney(3000);

        assertThat(out.toString())
                .contains("투입 금액: 3000원");
    }
    @DisplayName("잔돈 출력")
    @Test
    void printChange() {
        Change change = new Change(450);

        outputView.printChange(change.give(500));

        assertThat(out.toString())
                .contains("잔돈")
                .contains("100원 - 4개")
                .contains("50원 - 1개");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError() {
        outputView.printError("[ERROR] 금액은 10원 단위 이어야 합니다.");

        assertThat(out.toString())
                .contains("[ERROR] 금액은 10원 단위 이어야 합니다.");
    }
}
