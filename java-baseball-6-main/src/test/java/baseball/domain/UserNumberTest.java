package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNumberTest {

    @DisplayName("1~9 범위를 벗어날 때, 예외 처리")
    @Test
    void checkRange(){
        UserNumber userNumber = new UserNumber();

        assertThatThrownBy(() -> userNumber.checkRange(List.of(1,2,10)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userNumber.checkRange(List.of(0,1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 때, 예외 처리")
    @Test
    void checkDuplication(){

        UserNumber userNumber = new UserNumber();

        assertThatThrownBy(() -> userNumber.checkDuplication(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userNumber.checkDuplication(List.of(3, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
