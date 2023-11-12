package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Food;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DiscountPolicyTest {
    private static OrderedMenu orderedMenu;

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

        orderedMenu = new OrderedMenu(menu);
    }

    @DisplayName("크리스마스 디데이 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "10,1900", "25,3400", "26, 0", "31,0"})
    void calculateChristmas(Integer day, Integer discountPrice) {
        assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(discountPrice);
    }

    @DisplayName("크리스마스 디데이 할인 금액 반환, 25일 까지")
    @Test
    void calculateChristmasUntil25th() {
        for (int day = 1; day <= 25; day++) {
            assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(1000 + (day - 1) * 100);
        }
    }

    @DisplayName("크리스마스 디데이 할인 금액 반환, 25일 이후")
    @Test
    void calculateChristmasAfter25th() {
        for (int day = 26; day <= 31; day++) {
            assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(0);
        }
    }

//    @DisplayName("할인 대상 검증")
//    @ParameterizedTest
//    @CsvSource(value = {"10000,true", "25000,true", "9999,false", "3000,false"})
//    void checkTarget(Integer totalAmount, boolean isTarget) {
//        assertThat(DiscountPolicy.checkTarget(totalAmount)).isEqualTo(isTarget);
//
//    }

    @DisplayName("평일 할인 금액 반환, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekdayByWeekday(Integer day) {
        assertThat(DiscountPolicy.calculateWeekday(day, orderedMenu)).isEqualTo(2023 * 2);
    }

    @DisplayName("평일 할인 금액 반환, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void calculateWeekdayByWeekend(Integer day) {
        assertThat(DiscountPolicy.calculateWeekday(day, orderedMenu)).isEqualTo(0);
    }


    @DisplayName("주말 할인 금액 반환, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekendByWeekday(Integer day) {
        assertThat(DiscountPolicy.calculateWeekend(day, orderedMenu)).isEqualTo(0);
    }

    @DisplayName("주말 할인 금액 반환, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void calculateWeekendByWeekend(Integer day) {
        assertThat(DiscountPolicy.calculateWeekend(day, orderedMenu)).isEqualTo(2023 * 4);
    }

    @DisplayName("특별 할인 받는 날, 일요일 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void calculateSpecialByTheDay(Integer day) {
        assertThat(DiscountPolicy.calculateSpecial(day)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 받지 못하는 날")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15,
            18, 19, 20, 21, 22,
            26, 27, 28, 29
    })
    void calculateSpecialByNotTheDay(Integer day) {
        assertThat(DiscountPolicy.calculateSpecial(day)).isEqualTo(0);
    }

    @DisplayName("증정 이벤트 개수 반환")
    @ParameterizedTest
    @CsvSource(value = {"119999,0", "120000,1", "150000,1", "240000,2"})
    void giveFreeGift(Integer totalAmount, Integer count) {
        assertThat(DiscountPolicy.checkFreeGift(totalAmount)).isEqualTo(count);
    }

    @DisplayName("증정 이벤트 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"119999,0", "120000,25000", "150000,25000", "240000,50000"})
    void calculateFreeGift(Integer totalAmount, Integer count) {
        assertThat(DiscountPolicy.calculateFreeGift(totalAmount)).isEqualTo(count);
    }

    // 샴페인 모두 2개씩
    @DisplayName("총 할인 금액 계산, 주말 할인")
    @ParameterizedTest
    @ValueSource(ints = {29, 30})
    void calculateTotalDiscountByWeekend(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(58092); // 샴페인 50000 + 주말 (2023 * 4)
    }

    @DisplayName("총 할인 금액 계산, 주말 + 크리스 마스 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23
    })
    void calculateTotalDiscountByWeekendAndXmas(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(58092
                + (1000 + (day - 1) * 100)); // 주말 할인 58092 + 크리스마스 할인 1000+(day-1)*100
    }

    @DisplayName("총 할인 금액 계산, 평일 할인")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28})
    void calculateTotalDiscountByWeekday(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(54046); // 샴페인 50000 + 평일 (2023 * 2)
    }

    @DisplayName("총 할인 금액 계산, 평일 + 크리스마스 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            4, 5, 6, 7,
            11, 12, 13, 14,
            18, 19, 20, 21,
    })
    void calculateTotalDiscountByWeekdayAndXmas(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(54046
                + (1000 + (day - 1) * 100)); // 평일 할인 54046 + 크리스마스 할인 1000+(day-1)*100
    }

    @DisplayName("총 할인 금액 계산, 평일 + 특별 할인")
    @ParameterizedTest
    @ValueSource(ints = {31})
    void calculateTotalDiscountByWeekdayAndSpecial(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(55046); // 샴페인 50000 + 평일 (2023 * 2) + 특별 1000
    }

    @DisplayName("총 할인 금액 계산, 평일 + 크리스마스 + 특별 할인")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25})
    void calculateTotalDiscountByWeekdayAndXmasAndSpecial(Integer day) {
        assertThat(DiscountPolicy.calculateTotalDiscount(day, orderedMenu.calculateTotalAmount(),
                orderedMenu)).isEqualTo(55046
                + (1000 + (day - 1) * 100)); // 평일 + 특별 할인 55046 + 크리스마스 할인 1000+(day-1)*100
    }
}
