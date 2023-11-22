package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputViewTest {

    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("발행한 로또 수량 및 번호 오름차순 출력")
    @Test
    void printLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        outputView.printLotto(lottos);

        assertThat(out.toString())
                .contains("1개를 구매했습니다.")
                .contains("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 내역 출력")
    @Test
    void printResult() {
        Map<Prize, Integer> lottoResult = new HashMap<>();
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, 0);
        }
        lottoResult.replace(Prize.FIFTH, 1);
        lottoResult.replace(Prize.SECOND, 2);

        outputView.printResult(lottoResult);

        assertThat(out.toString())
                .contains("당첨 통계")
                .contains("---")
                .contains("3개 일치 (5,000원) - 1개")
                .contains("4개 일치 (50,000원) - 0개")
                .contains("5개 일치 (1,500,000원) - 0개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개")
                .contains("6개 일치 (2,000,000,000원) - 0개");
    }

    @DisplayName("수익률(둘째 자리에서 반올림) 출력")
    @ParameterizedTest
    @ValueSource(doubles = {62.455, 62.46})
    void printEarningsRate(Double earningsRate) {
        outputView.printEarningsRate(earningsRate);

        assertThat(out.toString())
                .contains("총 수익률은 62.5%입니다.");
    }
}
