package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.constants.Food;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ReservedMenuTest {
    private static ReservedMenu reservedMenu;
    private Map<Food, Integer> menu;

    @BeforeAll
    static void beforeAll() {
        Map<Food, Integer> menu = new HashMap<>();

        // 애피타이저 - 3, 22,000원
        menu.put(Food.MUSHROOM_SOUP, 1);
        menu.put(Food.CAESAR_SALAD, 2);
        // 메인 - 4, 189,000원, 주말 할인 8,092원
        menu.put(Food.T_BONE_STEAK, 2);
        menu.put(Food.BBQ_RIBS, 1);
        menu.put(Food.CHRISTMAS_PASTA, 1);
        // 디저트 - 2, 20,000원, 평일 할인 4,046원
        menu.put(Food.CHOCO_CAKE, 1);
        menu.put(Food.ICE_CREAM, 1);
        // 음료 -3, 88,000원
        menu.put(Food.ZERO_COLA, 1);
        menu.put(Food.RED_WINE, 1);
        menu.put(Food.CHAMPAGNE, 1);

        // 총 주문 금액: 319,000원

        reservedMenu = new ReservedMenu(menu);
    }

    @BeforeEach
    void beforeEach() {
        menu = new HashMap<>();
    }

    @DisplayName("한 메뉴를 1개 이상으로 주문할 때, 예외 처리 x")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void checkFoodCountByOneOrMore(Integer foodCount) {
        // given
        menu.put(Food.MUSHROOM_SOUP, foodCount);

        // when, then
        assertDoesNotThrow(() -> new ReservedMenu(menu));
    }

    @DisplayName("한 메뉴를 1개 미만으로 주문할 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkFoodCountByUnderOne(Integer foodCount) {
        // given
        menu.put(Food.MUSHROOM_SOUP, foodCount);

        // when, then
        assertThatThrownBy(() -> new ReservedMenu(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료 이외의 메뉴를 주문할 때, 예외 처리x")
    @Test
    void checkOnlyDrinkByNotOnlyDrink() {
        // given
        menu.put(Food.MUSHROOM_SOUP, 5);

        // when, then
        assertDoesNotThrow(() -> new ReservedMenu(menu));
    }

    @DisplayName("음료만 주문할 때, 예외 처리")
    @Test
    void checkOnlyDrinkByOnlyDrink() {
        // given
        menu.put(Food.ZERO_COLA, 5);
        menu.put(Food.RED_WINE, 1);

        // when, then
        assertThatThrownBy(() -> new ReservedMenu(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문 음식 수량이 20개 이하일 때, 예외 처리x")
    @Test
    void checkTotalFoodCountByTwentyOrLess() {
        // given
        menu.put(Food.MUSHROOM_SOUP, 5);
        menu.put(Food.T_BONE_STEAK, 15);

        // when, then
        assertDoesNotThrow(() -> new ReservedMenu(menu));
    }

    @DisplayName("총 주문 음식 수량이 20개 초과일 때, 예외 처리")
    @Test
    void checkTotalFoodCountByOverTwenty() {
        // given
        menu.put(Food.MUSHROOM_SOUP, 5);
        menu.put(Food.T_BONE_STEAK, 16);

        // when, then
        assertThatThrownBy(() -> new ReservedMenu(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("에약한 주문 메뉴의 메인 개수 체크")
    @Test
    void checkMain() {
        assertThat(reservedMenu.countMain()).isEqualTo(4);
    }

    @DisplayName("에약한 주문 메뉴의 디저트 개수 체크")
    @Test
    void checkDessert() {
        assertThat(reservedMenu.countDessert()).isEqualTo(2);
    }

    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateTotalAmount() {
        assertThat(reservedMenu.calculateTotalAmount()).isEqualTo(319000);
    }
}
