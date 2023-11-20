package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {
    private static ComputerNumber computerNumber;

    @BeforeAll
    static void beforeAll(){
        computerNumber = new ComputerNumber();
    }

    @DisplayName("1~9 범위의 3개의 숫자 생성")
    @Test
    void generate() {
        for (int i = 0; i < 3; i++) {
            assertThat(computerNumber.get().get(i)).isGreaterThan(0)
                    .isLessThan(10);
        }
    }

    @DisplayName("1~9 범위의 3개의 서로 다른 숫자 생성")
    @Test
    void generateByDifferentNumbers() {
        assertThat(computerNumber.get().size()).isEqualTo(Set.of(computerNumber.get().toArray()).size());
    }
}
