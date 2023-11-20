package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    @DisplayName("문자열을 Integer 리스트로 변환")
    @Test
    void convertToList(){
        assertThat(Converter.convertToList("12345")).isEqualTo(List.of(1,2,3,4,5));
    }

    @DisplayName("문자열이 정수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ","","a","1.0","a1"})
    void convertToListByNotInteger(String number){

        assertThatThrownBy(() -> Converter.convertToList(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
