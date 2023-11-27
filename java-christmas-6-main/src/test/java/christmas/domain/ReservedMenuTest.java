package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constants.Food;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReservedMenuTest {

    @DisplayName("음료만 주문할 때, 예외 처리")
    @Test
    void checkOnlyDrink() {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(Food.ZERO_COLA, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한 주문의 메뉴 수가 20개를 넘을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {21, 30})
    void checkTotalCount(Integer totalCount) {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(Food.T_BONE_STEAK, totalCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 1개 미만으로 주문할 때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void checkMenuCount(Integer menuCount) {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(Food.T_BONE_STEAK, menuCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}