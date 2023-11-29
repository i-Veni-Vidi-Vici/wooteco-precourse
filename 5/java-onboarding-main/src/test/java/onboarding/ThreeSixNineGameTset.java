package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ThreeSixNineGameTset {

    @DisplayName("짝 계산")
    @ParameterizedTest
    @CsvSource(value = {"13,4", "33,14"})
    void calculateClap(Integer number, Integer clapCount) {
        assertThat(calculateClap(number)).isEqualTo(clapCount);
    }
}
