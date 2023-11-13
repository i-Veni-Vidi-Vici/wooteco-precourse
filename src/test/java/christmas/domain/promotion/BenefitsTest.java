package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;


import christmas.constants.Food;
import christmas.domain.ReservedMenu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BenefitsTest {
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

    @DisplayName("혜택 적용 대상 체크, 총 구매 금액 10,000원 이상 => 대상")
    @Test
    void checkTarget() {
        Benefits benefits = new Benefits(1, reservedMenu);
        assertThat(benefits.getBenefits()).isNotEmpty();
    }

    @DisplayName("혜택 적용 대상 체크, 총 구매 금액 10,000원 미만 => not 대상")
    @Test
    void checkTargetByNotApply() {
        // given
        Map<Food, Integer> menu = new HashMap<>();
        menu.put(Food.CAESAR_SALAD, 1);
        ReservedMenu reservedMenu = new ReservedMenu(menu); // 총 구매 금액 8,000원

        // when
        Benefits benefits = new Benefits(1, reservedMenu);

        // then
        assertThat(benefits.getBenefits()).isEmpty();
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 주말")
    @ParameterizedTest
    @ValueSource(ints = {29, 30})
    void calculateTotalDiscountByWeekend(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit()).isEqualTo(33092); // 샴페인 25000 + 주말 (2023 * 4)
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 주말 + 크리스 마스")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23
    })
    void calculateTotalDiscountByWeekendAndXmas(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit()).isEqualTo(33092
                + (1000 + (date - 1) * 100)); // 샴페인, 주말  33092 + 크리스마스 (1000 + (date - 1) * 100)
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 평일")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28})
    void calculateTotalDiscountByWeekday(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit())
                .isEqualTo(29046); // 샴페인 25000 + 평일 (2023 * 2)
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 평일 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {
            4, 5, 6, 7,
            11, 12, 13, 14,
            18, 19, 20, 21,
    })
    void calculateTotalDiscountByWeekdayAndXmas(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit()).isEqualTo(29046
                + (1000 + (date - 1) * 100)); // 샴페인, 평일 29046 + 크리스마스 (1000 + (date - 1) * 100)
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 평일 + 특별")
    @ParameterizedTest
    @ValueSource(ints = {31})
    void calculateTotalDiscountByWeekdayAndSpecial(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit())
                .isEqualTo(30046); // 샴페인 25000 + 평일 (2023 * 2) + 특별 1000
    }

    @DisplayName("총 혜택 금액 계산, 샴페인 + 평일 + 크리스마스 + 특별")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25})
    void calculateTotalDiscountByWeekdayAndXmasAndSpecial(Integer date) {
        Benefits benefits = new Benefits(date, reservedMenu);
        assertThat(benefits.calculateTotalBenefit()).isEqualTo(30046
                + (1000 + (date - 1) * 100)); // 샴페인 + 평일 + 특별 30046 + 크리스마스 (1000 + (date - 1) * 100)
    }

    @DisplayName("할인 후 예상 결제 금액 계산")
    @Test
    void discount(){
        Benefits benefits = new Benefits(1, reservedMenu);
        assertThat(benefits.discount())
                .isEqualTo(319000 - 9092); // 샴페인 제외, 주말 + 크리스마스 9092원 할인
    }

    @DisplayName("증정 이벤트 대상 체크, 할인 전 총 주문 금액이 12만원 이상 => 대상")
    @Test
    void checkGiveaway(){
        Benefits benefits = new Benefits(1, reservedMenu); // 총 주문 금액: 319,000원
        assertThat(benefits.checkGiveaway()).isEqualTo(true);
    }

    @DisplayName("증정 이벤트 대상 체크, 할인 전 총 주문 금액이 12만원 미만 => not 대상")
    @Test
    void checkGiveawayByNotTarget(){
        // given
        Map<Food, Integer> menu = new HashMap<>();
        menu.put(Food.CAESAR_SALAD, 1);
        ReservedMenu reservedMenu = new ReservedMenu(menu); // 총 구매 금액 8,000원
        Benefits benefits = new Benefits(1, reservedMenu);

        // when, then
        assertThat(benefits.checkGiveaway()).isEqualTo(false);
    }

}
