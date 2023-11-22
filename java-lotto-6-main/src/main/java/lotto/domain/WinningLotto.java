package lotto.domain;

import static lotto.constants.ERROR.BONUS_NUMBER_DUPLICATION_ERROR;

public class WinningLotto {
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        checkBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumber(Integer bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
