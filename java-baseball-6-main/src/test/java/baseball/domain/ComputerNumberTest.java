package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @DisplayName("1~9 범위의 3개의 숫자 생성")
    @Test
    void generate(){
        ComputerNumber computerNumber = new ComputerNumber();

        for (int i = 0; i <3 ; i++) {
            assertThat(computerNumber.get().get(i)).isGreaterThan(0)
                    .isLessThan(10);
        }
    }

    @DisplayName("1~9 범위의 3개의 서로 다른 숫자 생성")
    @Test
    void generateByDifferentNumbers(){
        ComputerNumber computerNumber = new ComputerNumber();

        assertThat(computerNumber.get().size()).isEqualTo(Set.of(computerNumber.get().toArray()).size());
    }
}
