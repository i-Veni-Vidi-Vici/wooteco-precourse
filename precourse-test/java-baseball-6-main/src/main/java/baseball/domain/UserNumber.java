package baseball.domain;

import static baseball.constants.Value.MAX_NUMBER;
import static baseball.constants.Value.MIN_NUMBER;
import static baseball.constants.Value.NUMBERS_SIZE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        checkSize(userNumber);
        checkRange(userNumber);
        checkDuplication(userNumber);
        this.userNumber = userNumber;
    }

    private void checkSize(List<Integer> userNumbers) {
        if (userNumbers.size() != NUMBERS_SIZE.get()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(List<Integer> userNumbers) {
        for (Integer userNumber : userNumbers) {
            if ((userNumber < MIN_NUMBER.get()) || (userNumber > MAX_NUMBER.get())) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplication(List<Integer> userNumbers) {
        Set<Integer> differentNumbers = new HashSet<>(userNumbers);

        if (userNumbers.size() != differentNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> get() {
        return Collections.unmodifiableList(userNumber);
    }
}
