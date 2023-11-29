package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GreenFrogTest {

    @DisplayName("문자열 변환")
    @ParameterizedTest
    @CsvSource(value = {"A,Z,","z,a"})
    void reverse(String value, String result){
        GreenFrog greenFrog = new GreenFrog();
        assertThat(greenFrog.convert(value)).isEqualTo(result);
    }
}
