package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RestartTest {

    @DisplayName("1(재시작) = true, 2(종료) = false")
    @ParameterizedTest
    @CsvSource(value = {"1,true","2,false"})
    void isRestart(Integer restartNumber,boolean isRestart){
        Restart restart = new Restart(restartNumber);
        assertThat(restart.isRestart()).isEqualTo(isRestart);
    }

    @DisplayName("1과 2가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,3})
    void checkRange(Integer restartNumber){
        assertThatThrownBy(() -> new Restart(restartNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
