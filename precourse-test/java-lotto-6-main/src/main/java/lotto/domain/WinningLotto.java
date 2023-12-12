package lotto.domain;

import static lotto.constants.Error.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constants.Error.RANGE_ERROR;
import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER;

public class WinningLotto {
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        checkDuplication(bonusNumber);
        checkRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplication(Integer bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }

    private void checkRange(Integer bonusNumber) {
        if ((bonusNumber < MIN_LOTTO_NUMBER.get()) || (bonusNumber > MAX_LOTTO_NUMBER.get())) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
