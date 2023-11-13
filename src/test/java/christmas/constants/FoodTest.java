package christmas.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FoodTest {

    @DisplayName("입력된 메뉴가 없는 메뉴일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"토마토파스타", "레드와인1", " 타파스", "양송이 수프"})
    void checkExistence(String userInput){
        assertThatThrownBy(() -> Food.checkExistence(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
