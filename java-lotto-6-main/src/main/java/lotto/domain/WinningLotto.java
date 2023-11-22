package lotto.domain;

public class WinningLotto {

    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        checkBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumber(Integer bonusNumber){
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 숫자 입니다.");
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
