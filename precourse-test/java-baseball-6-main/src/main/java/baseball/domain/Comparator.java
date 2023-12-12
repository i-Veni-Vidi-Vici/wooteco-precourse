package baseball.domain;

import static baseball.constants.Value.FIRST_INDEX;
import static baseball.constants.Value.INITIAL_ZERO;
import static baseball.constants.Value.NUMBERS_SIZE;

import java.util.List;

public class Comparator {
    public Integer calculateStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Integer strikeCount = INITIAL_ZERO.get();

        for (int index = FIRST_INDEX.get(); index < NUMBERS_SIZE.get(); index++) {
            if (userNumbers.get(index).equals(computerNumbers.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public Integer calculateBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Integer ballCount = INITIAL_ZERO.get();

        for (int index = FIRST_INDEX.get(); index < NUMBERS_SIZE.get(); index++) {
            if ((!userNumbers.get(index).equals(computerNumbers.get(index))) && (computerNumbers.contains(
                    userNumbers.get(index)))) {
                ballCount++;
            }
        }

        return ballCount;
    }
}
