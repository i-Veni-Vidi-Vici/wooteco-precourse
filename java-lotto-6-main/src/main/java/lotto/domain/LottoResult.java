package lotto.domain;

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
            lottoResult.put(prize, 0);
        }
    }

    private void calculate(List<Lotto> lottos, List<Integer> winningLotto, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            Integer matchingCount = calculateMatchingCount(lotto, winningLotto);

            if (matchingCount >= 3) {
                Prize prize = Prize.calculate(matchingCount, hasBonusNumber(lotto, bonusNumber));
                lottoResult.put(prize, lottoResult.get(prize) + 1);
            }
        }
    }

    private Integer calculateMatchingCount(Lotto lotto, List<Integer> winningLotto) {
        Integer matchingCount = 0;

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
        double sum = 0;
        for (Prize prize : lottoResult.keySet()) {
            sum += lottoResult.get(prize) * prize.getPrizeMoney();
        }

        return ((sum / (1000 * lottoCount)) * 100);
    }
}
