package christmas.domain;

import static christmas.constants.Food.BBQ_RIB;
import static christmas.constants.Food.CHOCO_CAKE;
import static christmas.constants.Food.CHRISTMAS_PASTA;
import static christmas.constants.Food.T_BONE_STEAK;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BenefitTest {

//    @DisplayName("크리스마스 디데이 할인, 1~25")
//    @Test
//    void discountXmas() {
//        Benefit benefit = new Benefit();
//
//        for (int date = 1; date <= 25; date++) {
//            assertThat(benefit.discountXmas(date)).isEqualTo(1000 + ((date - 1) * 100));
//        }
//    }
//
//    @DisplayName("크리스마스 디데이 할인, 26~31 할인 x")
//    @Test
//    void discountXmasByNotPeriod() {
//        Benefit benefit = new Benefit();
//
//        for (int date = 26; date <= 31; date++) {
//            assertThat(benefit.discountXmas(date)).isEqualTo(0);
//        }
//    }
//
//    @DisplayName("평일 할인, 평일 + 디저트 ")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            3, 4, 5, 6, 7,
//            10, 11, 12, 13, 14,
//            17, 18, 19, 20, 21,
//            24, 25, 26, 27, 28,
//            31
//    })
//    void discountWeekday(Integer date) {
//        Benefit benefit = new Benefit();
//
//        for (int dessertCount = 1; dessertCount < 3; dessertCount++) {
//            assertThat(benefit.discountWeekday(date, dessertCount)).isEqualTo(2023 * dessertCount);
//        }
//    }
//
//    @DisplayName("평일 할인, 주말")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            1, 2,
//            8, 9,
//            15, 16,
//            22, 23,
//            29, 30
//    })
//    void discountWeekdayByNotWeekday(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountWeekday(date, 1)).isEqualTo(0);
//    }
//
//    @DisplayName("평일 할인, 평일 + 디저트x ")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            3, 4, 5, 6, 7,
//            10, 11, 12, 13, 14,
//            17, 18, 19, 20, 21,
//            24, 25, 26, 27, 28,
//            31
//    })
//    void discountWeekdayByNotDessert(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountWeekday(date, 0)).isEqualTo(0);
//    }
//
//    @DisplayName("주말 할인, 주말 + 메인 ")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            1, 2,
//            8, 9,
//            15, 16,
//            22, 23,
//            29, 30
//    })
//    void discountWeekend(Integer date) {
//        Benefit benefit = new Benefit();
//
//        for (int mainCount = 1; mainCount < 3; mainCount++) {
//            assertThat(benefit.discountWeekend(date, mainCount)).isEqualTo(2023 * mainCount);
//
//        }
//    }
//
//    @DisplayName("주말 할인, 주말 + 메인 x")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            1, 2,
//            8, 9,
//            15, 16,
//            22, 23,
//            29, 30
//    })
//    void discountWeekendByNotMain(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountWeekend(date, 0)).isEqualTo(0);
//    }
//
//    @DisplayName("주말 할인, 평일")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            3, 4, 5, 6, 7,
//            10, 11, 12, 13, 14,
//            17, 18, 19, 20, 21,
//            24, 25, 26, 27, 28,
//            31
//    })
//    void discountWeekendByNotWeekend(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountWeekend(date, 1)).isEqualTo(0);
//    }
//
//    @DisplayName("특별 할인, 별표 날")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            3, 10, 17, 24, 25, 31
//    })
//    void discountSpecial(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountSpecial(date)).isEqualTo(1000);
//    }
//
//    @DisplayName("특별 할인, 별표 날x")
//    @ParameterizedTest
//    @ValueSource(ints = {
//            1, 2,
//            4, 5, 6, 7, 8, 9,
//            11, 12, 13, 14, 15, 16,
//            18, 19, 20, 21, 22, 23,
//            26, 27, 28, 29, 30
//    })
//    void discountSpecialByNotSpecialDay(Integer date) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.discountSpecial(date)).isEqualTo(0);
//    }
//
//    @DisplayName("증정 이벤트, 12만원 이상일 때 샴페인 증정")
//    @ParameterizedTest
//    @ValueSource(ints = {120_000, 150_000})
//    void presentGiveaway(Integer purchaseAmount) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.presentGiveaway(purchaseAmount)).isEqualTo(true);
//    }
//
//    @DisplayName("증정 이벤트, 12만원 미만일 때 증정x")
//    @ParameterizedTest
//    @ValueSource(ints = {0, 119_000})
//    void presentGiveawayByNotApplicable(Integer purchaseAmount) {
//        Benefit benefit = new Benefit();
//
//        assertThat(benefit.presentGiveaway(purchaseAmount)).isEqualTo(false);
//    }

    @DisplayName("총 혜택 금액 계산, 평일 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            26, 27, 28
    })
    void calculateBenefitAmountByWeekday(Integer date) {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(date);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu)).isEqualTo(2023);
    }

    @DisplayName("총 혜택 금액 계산, 주말 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            29, 30
    })
    void calculateBenefitAmountByWeekend(Integer date) {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(date);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu)).isEqualTo(2023 * 2);
    }

    @DisplayName("총 혜택 금액 계산, 평일 + 특별")
    @Test
    void calculateBenefitAmountByWeekdayAndSpecial() {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(31);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu)).isEqualTo(2023 + 1000);
    }

    @DisplayName("총 혜택 금액 계산, 평일 + 특별 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 10, 17, 24, 25
    })
    void calculateBenefitAmountByWeekdayAndSpecialAndXmas(Integer date) {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(date);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu)).isEqualTo(
                2023 + 1000 + (1000 + ((date - 1) * 100)));
    }

    @DisplayName("총 혜택 금액 계산, 평일 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {
            4, 5, 6, 7,
            11, 12, 13, 14,
            18, 19, 20, 21
    })
    void calculateBenefitAmountByWeekdayAndXmas(Integer date) {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(date);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu)).isEqualTo(
                2023 + (1000 + ((date - 1) * 100)));
    }

    @DisplayName("총 혜택 금액 계산, 주말 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23
    })
    void calculateBenefitAmountByWeekendAndXmas(Integer date) {
        Benefit benefit = new Benefit();
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
        ReservedDate reservedDate = new ReservedDate(date);

        assertThat(benefit.calculateBenefitAmount(reservedDate, reservedMenu))
                .isEqualTo(2023 * 2 + (1000 + ((date - 1) * 100)));
    }
}
