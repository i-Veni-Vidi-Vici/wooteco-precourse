package lotto.domain;

import static lotto.constants.Value.INITIAL_ZERO;
import static lotto.constants.Value.MIN_MATCHING_COUNT;
import static lotto.constants.Value.ONE;
import static lotto.constants.Value.PERCENT;
import static lotto.constants.Value.THOUSAND_WON;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;

public class LottoResult {
    private Map<Prize, Integer> lottoResult;
    private final Integer lottoCount;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        initialize();
        lottoCount = lottos.size();
        calculate(lottos, winningLotto.getWinningNumber().getNumbers(), winningLotto.getBonusNumber());
    }

    private void initialize() {
        lottoResult = new HashMap<>();

        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, INITIAL_ZERO.get());
        }
    }

    private void calculate(List<Lotto> lottos, List<Integer> winningLotto, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            Integer matchingCount = calculateMatchingCount(lotto, winningLotto);

            if (matchingCount >= MIN_MATCHING_COUNT.get()) {
                Prize prize = Prize.calculate(matchingCount, hasBonusNumber(lotto, bonusNumber));
                lottoResult.put(prize, lottoResult.get(prize) + ONE.get());
            }
        }
    }

    private Integer calculateMatchingCount(Lotto lotto, List<Integer> winningLotto) {
        Integer matchingCount = INITIAL_ZERO.get();

        for (Integer winningNumber : winningLotto) {
            if (lotto.getNumbers().contains(winningNumber)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }

    private boolean hasBonusNumber(Lotto lotto, Integer bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Map<Prize, Integer> get() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public double calculateEarningsRate() {
        double sum = INITIAL_ZERO.get();

        for (Prize prize : lottoResult.keySet()) {
            sum += lottoResult.get(prize) * prize.getPrizeMoney();
        }

        return ((sum / (THOUSAND_WON.get() * lottoCount)) * PERCENT.get());
    }
}
