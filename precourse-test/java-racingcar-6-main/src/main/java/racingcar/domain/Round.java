package racingcar.domain;

import static racingcar.constants.Value.MIN_ROUND_COUNT;

public class Round {

    private final Integer roundCount;

    public Round(Integer roundCount) {
        checkCount(roundCount);
        this.roundCount = roundCount;
    }

    private void checkCount(Integer roundCount) {
        if (roundCount < MIN_ROUND_COUNT.get()) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRoundCount() {
        return roundCount;
    }
}
