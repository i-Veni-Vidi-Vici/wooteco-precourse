package lotto.view;

import static lotto.constants.Message.COUNT;
import static lotto.constants.Message.EARNINGS_RATE;
import static lotto.constants.Message.EARNINGS_RATE_PERCENT;
import static lotto.constants.Message.LOTTO_PURCHASE;
import static lotto.constants.Message.WINNING_RESULT;
import static lotto.constants.Message.WON;
import static lotto.constants.Symbol.EARNINGS_RATE_FORMAT;
import static lotto.constants.Symbol.HYPHEN;
import static lotto.constants.Symbol.LEFT_PARENTHESIS;
import static lotto.constants.Symbol.PRIZE_FORMAT;
import static lotto.constants.Symbol.RIGHT_PARENTHESIS;
import static lotto.constants.Symbol.THREE_HYPHEN;
import static lotto.constants.Symbol.WHITESPACE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;
import lotto.domain.Lotto;

public class OutputView {

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + LOTTO_PURCHASE.getMessage());

        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public void printResult(Map<Prize, Integer> lottoResult) {
        System.out.println();
        System.out.println(WINNING_RESULT.getMessage());
        System.out.println(THREE_HYPHEN.get());

        for (Prize prize : Prize.values()) {
            System.out.println(prize.getMessage() + WHITESPACE.get() + LEFT_PARENTHESIS.get()
                    + String.format(PRIZE_FORMAT.get(), prize.getPrizeMoney()) + WON.getMessage()
                    + RIGHT_PARENTHESIS.get() + WHITESPACE.get() + HYPHEN.get() + WHITESPACE.get()
                    + lottoResult.get(prize) + COUNT.getMessage());
        }
    }

    public void printEarningsRate(Double earningsRate) {
        System.out.println(EARNINGS_RATE.getMessage() + String.format(EARNINGS_RATE_FORMAT.get(), earningsRate)
                + EARNINGS_RATE_PERCENT.getMessage());
    }
}
