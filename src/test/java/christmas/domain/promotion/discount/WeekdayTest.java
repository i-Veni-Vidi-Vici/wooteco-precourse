package christmas.domain.promotion.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.constants.Food;
import christmas.domain.ReservedMenu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayTest {
    private static ReservedMenu reservedMenu;

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

    @DisplayName("평일 할인 금액 계산, 디저트 2개 + 평일 => 2023 * 2")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekdayByWeekday(Integer date) {
        Weekday weekday = new Weekday(date, reservedMenu);
        assertThat(weekday.apply().get(Benefit.WEEKDAY)).isEqualTo(2023 * 2);
    }

    @DisplayName("평일 할인 금액 계산, 디저트 0개 + 평일 => not apply")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekdayByNotDessert(Integer date) {
        // given
        Map<Food, Integer> menu = new HashMap<>();
        menu.put(Food.T_BONE_STEAK, 1);
        ReservedMenu notDessertMenu = new ReservedMenu(menu);

        // when
        Weekday weekday = new Weekday(date, notDessertMenu);

        // then
        assertThat(weekday.apply()).isEmpty();
    }

    @DisplayName("평일 할인 금액 계산, 디저트 2개 + 주말 => not apply")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void calculateWeekdayByWeekend(Integer date) {
        Weekday weekday = new Weekday(date, reservedMenu);
        assertThat(weekday.apply()).isEmpty();
    }
}
