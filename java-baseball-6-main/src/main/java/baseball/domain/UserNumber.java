package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        checkRange(userNumber);
        checkDuplication(userNumber);
        this.userNumber = userNumber;
    }

    private void checkRange(List<Integer> userNumbers){
        for (Integer userNumber : userNumbers) {
            if((userNumber < 1) || (userNumber > 9)){
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
