package christmas.view;

import static christmas.constants.Food.CHOCO_CAKE;
import static christmas.constants.Food.T_BONE_STEAK;
import static christmas.constants.Food.ZERO_COLA;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Badge;
import christmas.domain.Benefit;
import christmas.domain.ReservedDate;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputViewTest {

    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("이벤트 플래너 시작 문구 출력")
    @Test
    void printPlanner() {
        outputView.printPlanner();

        assertThat(out.toString())
                .contains("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    @DisplayName("예약 날짜 출력")
    @Test
    void printDate() {
        outputView.printDate(25);

        assertThat(out.toString())
                .contains("12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    }

    @DisplayName("주문 메뉴 출력")
    @Test
    void printMenu() {
        outputView.printMenu(Map.of(T_BONE_STEAK, 1, CHOCO_CAKE, 2, ZERO_COLA, 3));

        assertThat(out.toString())
                .contains("<주문 메뉴>")
                .contains("티본스테이크 1개")
                .contains("초코케이크 2개")
                .contains("제로콜라 3개");
    }

    @DisplayName("할인 전 총 주문 금액 출력")
    @Test
    void printAmount() {
        outputView.printAmount(Map.of(T_BONE_STEAK, 1, CHOCO_CAKE, 2, ZERO_COLA, 3)); // 94,000원

        assertThat(out.toString())
                .contains("<할인 전 총주문 금액>")
                .contains("94,000원");
    }

    @DisplayName("증정 메뉴 12만 이상일 때 출력")
    @Test
    void printGiveawayByNotTarget() {
        outputView.printGiveaway(Map.of(T_BONE_STEAK, 2, CHOCO_CAKE, 2, ZERO_COLA, 3)); // 149,000원

        assertThat(out.toString())
                .contains("<할인 전 총주문 금액>")
                .contains("샴페인 1개");
    }


    @DisplayName("증정 메뉴 12만 미만일 때 없음 출력")
    @Test
    void printGiveawayByNotTarget() {
        outputView.printGiveaway(Map.of(T_BONE_STEAK, 1, CHOCO_CAKE, 2, ZERO_COLA, 3)); // 94,000원

        assertThat(out.toString())
                .contains("<할인 전 총주문 금액>")
                .contains("없음");
    }

    @DisplayName("혜택 내역 출력")
    @Test
    void printBenefit() {
        outputView.printBenefit(Map.of(
                "크리스마스 디데이 할인", 1000,
                "평일 할인", 2023,
                "특별 할인", 1000,
                "증정 이벤트", 25000));

        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("크리스마스 디데이 할인: -1,000원")
                .contains("평일 할인: -2,023원")
                .contains("특별 할인: -1,000원")
                .contains("증정 이벤트: -25,000원");
    }

    @DisplayName("혜택 내역 출력")
    @Test
    void printBenefitByNoting() {
        outputView.printBenefit(Map.of());

        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("없음");
    }

    @DisplayName("총혜택 금액 출력")
    @ParameterizedTest
    @CsvSource(value = {"31246,-31,246원", "0,0원"})
    void printBenefitAmount(Integer benefitAmount, String outputValue) {
        outputView.printBenefitAmount(benefitAmount);

        assertThat(out.toString())
                .contains("<총혜택 금액>")
                .contains(outputValue);
    }

    @DisplayName("할인 후 예상 결제 금액 출력")
    @Test
    void printPaymentAmount() {
        outputView.printPaymentAmount(31246);

        assertThat(out.toString())
                .contains("<할인 후 예상 결제 금액>")
                .contains("135,754원");
    }

    @DisplayName("이벤트 배지 출력")
    @Test
    void printBadge() {
        outputView.printBadge(Badge.SANTA);

        assertThat(out.toString())
                .contains("<12월 이벤트 배지>")
                .contains("산타");
    }
}
