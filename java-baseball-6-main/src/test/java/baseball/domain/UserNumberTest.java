package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNumberTest {

    @DisplayName("1~9 범위를 벗어날 때, 예외 처리")
    @Test
    void checkRange(){
        assertThatThrownBy(() -> new UserNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
