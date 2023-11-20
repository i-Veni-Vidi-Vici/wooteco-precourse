package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComparatorTest {

    @DisplayName("사용자 숫자와 컴퓨터 숫자 비교")
    @ParameterizedTest
    @CsvSource(value = {"123,145,1스트라이크"})
    void compareNumber(Set<Integer> userNumber, Set<Integer> computerNumber, String result){
        assertThat(compareNumber(userNumber, computerNumber)).isEqualTo(result);
    }

}
