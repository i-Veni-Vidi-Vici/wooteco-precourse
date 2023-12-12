package christmas.view;

import static christmas.constants.Error.INVALID_DATE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Badge;
import christmas.constants.Benefit;
import christmas.constants.Food;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputViewTest {
    private OutputStream out;
    private static OutputView outputView;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
    }

    @BeforeEach
    void beforeEach() {
        // given
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("12월 이벤트 플래너 시작 문구 출력")
    @Test
    void printPlanner() {
        // when
        outputView.printPlanner();

        // then
        assertThat(out.toString()).contains("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    @DisplayName("예약한 날짜에 대한 첫 이벤트 문구 출력")
    @Test
    void printDate() {
        // when
        outputView.printDate(3);

        // then
        assertThat(out.toString()).contains("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    @DisplayName("예약한 메뉴 출력")
    @Test
    void printMenu() {
        // given
        Map<Food, Integer> orderedMenu = new HashMap<>();
        orderedMenu.put(Food.T_BONE_STEAK, 1);
        orderedMenu.put(Food.ICE_CREAM, 2);

        // when
        outputView.printMenu(orderedMenu);

        // then
        assertThat(out.toString())
                .contains("<주문 메뉴>")
                .contains("티본스테이크 1개")
                .contains("아이스크림 2개");
    }

    @DisplayName("총 주문 금액 출력")
    @Test
    void printTotalAmount() {
        // when
        outputView.printTotalAmount(142000);

        // then
        assertThat(out.toString())
                .contains("<할인 전 총주문 금액>")
                .contains("142,000원");
    }

    @DisplayName("증정 메뉴 출력")
    @ParameterizedTest
    @CsvSource(value = {"true,샴페인 1개", "false,없음"})
    void printGiveaway(boolean giveaway, String print) {
        // when
        outputView.printGiveaway(giveaway);

        // then
        assertThat(out.toString())
                .contains("<증정 메뉴>")
                .contains(print);
    }

    @DisplayName("혜택이 있을 경우, 혜택 내역 출력")
    @Test
    void printBenefitDetails() {
        // given
        Map<Benefit, Integer> benefits = new HashMap<>();
        benefits.put(Benefit.XMAS, 1000);
        benefits.put(Benefit.WEEKDAY, 2023);
        benefits.put(Benefit.GIVEAWAY, 25000);

        // when
        outputView.printBenefitDetails(benefits);

        // then
        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("크리스마스 디데이 할인: -1,000원")
                .contains("평일 할인: -2,023원")
                .contains("증정 이벤트: -25,000원");

    }

    @DisplayName("혜택이 없을 경우, 없음 출력")
    @Test
    void printBenefitDetailsByNotBenefit() {
        // given
        Map<Benefit, Integer> benefits = new HashMap<>();

        // when
        outputView.printBenefitDetails(benefits);

        // then
        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("없음");
    }

    @DisplayName("총 헤택 금액 출력")
    @Test
    void printTotalBenefitAmount() {
        // when
        outputView.printTotalBenefitAmount(31246);

        // then
        assertThat(out.toString())
                .contains("<총혜택 금액>")
                .contains("-31,246원");
    }

    @DisplayName("혜택 금액이 없을 경우, 0원 출력")
    @Test
    void printTotalBenefitAmountByZero() {
        // when
        outputView.printTotalBenefitAmount(0);

        // then
        assertThat(out.toString())
                .contains("<총혜택 금액>")
                .contains("0원");
    }

    @DisplayName("할인 후 예상 결제 금액 출력")
    @Test
    void printPaymentAmount() {
        // when
        outputView.printPaymentAmount(135754);

        // then
        assertThat(out.toString())
                .contains("<할인 후 예상 결제 금액>")
                .contains("135,754원");
    }

    @DisplayName("산타 이벤트 배지 출력")
    @Test
    void printBadge() {
        // when
        outputView.printBadge(Badge.SANTA);

        // then
        assertThat(out.toString())
                .contains("<12월 이벤트 배지>")
                .contains("산타");
    }

    @DisplayName("없음 이벤트 배지 출력")
    @Test
    void printBadgeByNothing() {
        // when
        outputView.printBadge(Badge.NOTHING);

        // then
        assertThat(out.toString())
                .contains("<12월 이벤트 배지>")
                .contains("없음");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError(){
        // when
        outputView.printError(INVALID_DATE_ERROR.getMessage());

        // then
        assertThat(out.toString())
                .contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("true 일 때, 우테코 식당 전 메뉴 출력")
    @Test
    void printAllMenu() {
        // when
        outputView.printAllMenu(true);

        // then
        assertThat(out.toString())
                .contains("<애피타이저>")
                .contains("양송이수프(6,000원), 타파스(5,500원), 시저샐러드(8,000원)")
                .contains("<메인>")
                .contains("티본스테이크(55,000원), 바비큐립(54,000원), 해산물파스타(35,000원), 크리스마스파스타(25,000원)")
                .contains("<디저트>")
                .contains("초코케이크(15,000원), 아이스크림(5,000원)")
                .contains("<음료>")
                .contains("제로콜라(3,000원), 레드와인(60,000원), 샴페인(25,000원)");
    }

    @DisplayName("false 일 때, 우테코 식당 전 메뉴 출력 x")
    @Test
    void printAllMenuByFalse() {
        // when
        outputView.printAllMenu(false);

        // then
        assertThat(out.toString())
                .isEmpty();
    }
}
