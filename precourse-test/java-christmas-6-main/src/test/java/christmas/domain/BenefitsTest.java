package christmas.domain;

import static christmas.constants.Benefit.WEEKDAY;
import static christmas.constants.Food.CHOCO_CAKE;
import static christmas.constants.Food.CHRISTMAS_PASTA;
import static christmas.constants.Food.T_BONE_STEAK;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.promotion.Benefits;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BenefitsTest {
    private static ReservedMenu reservedMenu;

    @BeforeAll
    static void beforeAll() {
        reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 1, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 2개, 디저트 1개 = 95,000원
    }

    @DisplayName("총 혜택 금액 계산, 평일 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            26, 27, 28
    })
    void calculateBenefitAmountByWeekday(Integer date) {
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount()).isEqualTo(2023);
    }

    @DisplayName("총 혜택 금액 계산, 주말 할인")
    @ParameterizedTest
    @ValueSource(ints = {
            29, 30
    })
    void calculateBenefitAmountByWeekend(Integer date) {
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount()).isEqualTo(2023 * 2);
    }

    @DisplayName("총 혜택 금액 계산, 평일 + 특별")
    @Test
    void calculateBenefitAmountByWeekdayAndSpecial() {
        ReservedDate reservedDate = new ReservedDate(31);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount()).isEqualTo(2023 + 1000);
    }

    @DisplayName("총 혜택 금액 계산, 평일 + 특별 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 10, 17, 24, 25
    })
    void calculateBenefitAmountByWeekdayAndSpecialAndXmas(Integer date) {
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount()).isEqualTo(
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
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount()).isEqualTo(
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
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount())
                .isEqualTo(2023 * 2 + (1000 + ((date - 1) * 100)));
    }

    @DisplayName("총 혜택 금액 계산, 주말 + 샴페인")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23
    })
    void calculateBenefitAmountByGiveaway(Integer date) {
        ReservedMenu reservedMenu = new ReservedMenu(Map.of(T_BONE_STEAK, 2, CHRISTMAS_PASTA, 1,
                CHOCO_CAKE, 1)); // 메인 3개, 디저트 1개 = 150,000원
        ReservedDate reservedDate = new ReservedDate(date);
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculateBenefitAmount())
                .isEqualTo(2023 * 3 + (1000 + ((date - 1) * 100)) + 25000);
    }

    @DisplayName("할인 후 예상 결제 금액 계산")
    @Test
    void calculatePaymentAmount() {
        ReservedDate reservedDate = new ReservedDate(26); // 평일 할인 2023
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.calculatePaymentAmount()).isEqualTo(95000 - 2023);
    }

    @DisplayName("혜택 내역 생성")
    @Test
    void create() {
        ReservedDate reservedDate = new ReservedDate(26); // 평일 할인 2023
        Benefits benefits = new Benefits(reservedDate, reservedMenu);

        assertThat(benefits.get()).isEqualTo(Map.of(WEEKDAY, 2023));
        assertThat(benefits.get().size()).isEqualTo(1);
    }
}
