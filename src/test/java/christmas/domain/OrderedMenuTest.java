package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.constants.Food;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderedMenuTest {

    private Map<Food, Integer> orderedMenu;

    @BeforeEach
    void beforeEach() {
        orderedMenu = new HashMap<>();
    }

    @DisplayName("한 메뉴당 1개 이상 주문 시, 예외 처리 x")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void checkFoodCountByOneOrMore(Integer foodCount) {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, foodCount);

        // when, then
        assertDoesNotThrow(() -> new OrderedMenu(orderedMenu));
    }

    @DisplayName("한 메뉴당 1개 이상 주문 안할 시, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkFoodCountByUnderOne(Integer foodCount) {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, foodCount);

        // when, then
        assertThatThrownBy(() -> new OrderedMenu(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("총 주문 음식 수량이 20개를 넘지 않으면, 예외 처리x")
    @Test
    void checkTotalCountByTwentyOrLess() {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, 5);
        orderedMenu.put(Food.T_BONE_STEAK, 15);

        // when, then
        assertDoesNotThrow(() -> new OrderedMenu(orderedMenu));
    }

    @DisplayName("총 주문 음식 수량이 20개를 넘을 시, 예외 처리")
    @Test
    void checkTotalCountByOverTwenty() {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, 5);
        orderedMenu.put(Food.T_BONE_STEAK, 16);

        // when, then
        assertThatThrownBy(() -> new OrderedMenu(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료 이외의 메뉴도 주문시, 예외 처리x")
    @Test
    void checkOnlyDrinkByNotOnlyDrink() {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, 5);

        // when, then
        assertDoesNotThrow(() ->new OrderedMenu(orderedMenu));
    }

    @DisplayName("음료만 시키면, 예외 처리")
    @Test
    void checkOnlyDrinkByOnlyDrink() {
        // given
        orderedMenu.put(Food.ZERO_COLA, 5);
        orderedMenu.put(Food.RED_WINE, 1);

        // when, then
        assertThatThrownBy(() -> new OrderedMenu(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
