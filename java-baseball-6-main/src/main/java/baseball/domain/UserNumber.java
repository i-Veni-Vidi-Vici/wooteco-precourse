package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    public void checkRange(List<Integer> userNumbers){
        for (Integer userNumber : userNumbers) {
            if((userNumber < 1) || (userNumber > 9)){
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkDuplication(List<Integer> userNumbers) {
        Set<Integer> differentNumbers = new HashSet<>(userNumbers);

        if (userNumbers.size() != differentNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
