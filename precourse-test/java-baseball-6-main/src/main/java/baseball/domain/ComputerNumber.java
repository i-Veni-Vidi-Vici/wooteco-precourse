package baseball.domain;

import static baseball.constants.Value.MAX_NUMBER;
import static baseball.constants.Value.MIN_NUMBER;
import static baseball.constants.Value.NUMBERS_SIZE;

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

        while (computerNumber.size() < NUMBERS_SIZE.get()) {
            Integer randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.get(), MAX_NUMBER.get());

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(computerNumber);
    }
}
