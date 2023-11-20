package baseball.domain;

import java.util.List;
import java.util.Set;

public class Comparator {
    public Integer calculateStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Integer strikeCount = 0;

        for (int index = 0; index < 3; index++) {
            if (userNumbers.get(index).equals(computerNumbers.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public Integer calculateBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Integer ballCount = 0;

        for (int index = 0; index < 3; index++) {
            if ((!userNumbers.get(index).equals(computerNumbers.get(index))) && (computerNumbers.contains(
                    userNumbers.get(index)))) {
                ballCount++;
            }
        }

        return ballCount;
    }
}
