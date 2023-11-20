package baseball.domain;

import java.util.List;

public class UserNumber {

    public void checkRange(List<Integer> userNumbers){
        for (Integer userNumber : userNumbers) {
            if((userNumber < 1) || (userNumber > 9)){
                throw new IllegalArgumentException();
            }
        }
    }
}
