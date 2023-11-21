package racingcar.domain;

public class Round {

    private final Integer roundCount;

    public Round(Integer roundCount) {
        checkCount(roundCount);
        this.roundCount = roundCount;
    }

    private void checkCount(Integer roundCount){
        if (roundCount < 1) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRoundCount() {
        return roundCount;
    }
}
