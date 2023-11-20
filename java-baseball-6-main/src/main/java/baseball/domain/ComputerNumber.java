package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber() {
        generate();
    }

    private void generate() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(computerNumber);
    }
}
