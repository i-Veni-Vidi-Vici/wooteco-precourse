package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {

    @DisplayName("우승자 선별, 다수")
    @Test
    void selectWinnerByMany() {
        Judge judge = new Judge();

        Map<String, String> car = new LinkedHashMap<>();
        car.put("pobi", "-");
        car.put("woni", "");
        car.put("jun", "-");
        assertThat(judge.selectWinner(car)).isEqualTo(List.of("pobi","jun"));
    }

    @DisplayName("우승자 선별, 한명")
    @Test
    void selectWinnerByOne() {
        Judge judge = new Judge();

        Map<String, String> car = new LinkedHashMap<>();
        car.put("pobi", "---");
        car.put("woni", "--");
        car.put("jun", "-");
        assertThat(judge.selectWinner(car)).isEqualTo(List.of("pobi"));
    }
}
