package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;
import lotto.domain.Lotto;

public class OutputView {

    public void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public void printResult(Map<Prize, Integer> lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Prize prize : Prize.values()) {
            System.out.println(prize.getMessage() + " "
                    + "(" + String.format("%,d", prize.getPrizeMoney()) + "원"+")" + " " + "-" + " "
                    + lottoResult.get(prize) + "개");
        }
    }

    public void printEarningsRate(Double earningsRate) {
        System.out.println("총 수익률은 " + String.format("%,.1f",earningsRate) +"%입니다.");
    }
}
