package christmas.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FoodTest {

    @DisplayName("예약한 메뉴가 존재할 때, 메뉴 반환")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "티본스테이크", "제로콜라", "샴페인"})
    void checkExistence(String orderedFood) {
        assertThat(Food.checkExistence(orderedFood).getName()).isEqualTo(orderedFood);
    }

    @DisplayName("예약한 메뉴가 없는 메뉴일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"토마토파스타", "레드와인1", " 타파스", "양송이 수프"})
    void checkExistenceByInvalidMenu(String orderedFood) {
        assertThatThrownBy(() -> Food.checkExistence(orderedFood))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
