package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> generate(Integer money) {
        checkMoney(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < (money / 1000); count++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    private void checkMoney(Integer money) {
        if (((money % 1000) != 0) || (money == 0)) {
            throw new IllegalArgumentException();
        }
    }
}
