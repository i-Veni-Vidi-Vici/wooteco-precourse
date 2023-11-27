package lotto.domain;

import static lotto.constants.Error.THOUSAND_ERROR;
import static lotto.constants.LottoValue.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER;
import static lotto.constants.Value.INITIAL_ZERO;
import static lotto.constants.Value.REMAINDER_ZERO;
import static lotto.constants.Value.THOUSAND_WON;
import static lotto.constants.Value.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> generate(Integer money) {
        checkMoney(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int count = INITIAL_ZERO.get(); count < (money / THOUSAND_WON.get()); count++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.get(),
                    MAX_LOTTO_NUMBER.get(), LOTTO_NUMBER_SIZE.get())));
        }

        return lottos;
    }

    private void checkMoney(Integer money) {
        if (((money % THOUSAND_WON.get()) != REMAINDER_ZERO.get()) || (money.equals(ZERO.get()))) {
            throw new IllegalArgumentException(THOUSAND_ERROR.getMessage());
        }
    }
}
