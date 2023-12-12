package christmas.domain;

import static christmas.constants.Food.BBQ_RIB;
import static christmas.constants.Food.CAESAR_SALAD;
import static christmas.constants.Food.CHOCO_CAKE;
import static christmas.constants.Food.ICE_CREAM;
import static christmas.constants.Food.T_BONE_STEAK;
import static christmas.constants.Food.ZERO_COLA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReservedMenuTest {

    @DisplayName("음료만 주문할 때, 예외 처리")
    @Test
    void checkOnlyDrink() {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(ZERO_COLA, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한 주문의 메뉴 수가 20개를 넘을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {21, 30})
    void checkTotalCount(Integer totalCount) {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(T_BONE_STEAK, totalCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 1개 미만으로 주문할 때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void checkMenuCount(Integer menuCount) {
        assertThatThrownBy(() -> new ReservedMenu(Map.of(T_BONE_STEAK, menuCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateAmount() {
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(CAESAR_SALAD, 1, T_BONE_STEAK, 1)); // 63,000 원

        assertThat(reservedMenu.calculateAmount()).isEqualTo(63000);
    }

    @DisplayName("디저트 개수 계산")
    @Test
    void countDessert() {
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(CAESAR_SALAD, 1, T_BONE_STEAK, 1,
                CHOCO_CAKE, 3, ICE_CREAM, 2));

        assertThat(reservedMenu.countDessert()).isEqualTo(5);
    }

    @DisplayName("메인 개수 계산")
    @Test
    void countMain() {
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(CAESAR_SALAD, 1, T_BONE_STEAK, 1, BBQ_RIB, 2));

        assertThat(reservedMenu.countMain()).isEqualTo(3);
    }

}