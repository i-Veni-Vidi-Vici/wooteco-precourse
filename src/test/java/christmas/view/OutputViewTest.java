package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Food;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputViewTest {
    private OutputStream out;

    @BeforeEach
    void beforeEach() {
        // given
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("12월 이벤트 플래너 시작 문구 출력")
    @Test
    void printPlanner(){
        // when
        OutputView.printPlanner();

        // then
        assertThat(out.toString()).contains("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }


    @DisplayName("예약한 날짜에 대한 첫 이벤트 문구 출력")
    @Test
    void printDate(){
        // when
        OutputView.printDate(3);

        // then
        assertThat(out.toString()).contains("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    @DisplayName("예약한 메뉴 출력")
    @Test
    void printMenu(){
        Map<Food, Integer> orderedMenu = new HashMap<>();
        orderedMenu.put(Food.T_BONE_STEAK, 1);
        orderedMenu.put(Food.ICE_CREAM, 2);
        // when
        OutputView.printMenu(orderedMenu);

        // then
        assertThat(out.toString())
                .contains("<주문 메뉴>")
                .contains("티본스테이크 1개")
                .contains("아이스크림 2개");
    }

    @DisplayName("총 주문 금액 출력")
    @Test
    void printTotalAmount(){
        // when
        OutputView.printTotalAmount(142000);

        // then
        assertThat(out.toString())
                .contains("<할인 전 총주문 금액>")
                .contains("142,000원");
    }

    @DisplayName("12만원 이상일 때, 증정 메뉴 출력")
    @ParameterizedTest
    @CsvSource(value = {"true,샴페인 1개","false,없음"})
    void printFreeGift(boolean freeGift, String print){
        // when
        OutputView.printFreeGift(freeGift);

        // then
        assertThat(out.toString())
                .contains("<증정 메뉴>")
                .contains(print);
    }

    @DisplayName("혜택이 있을 경우, 혜택 내역 출력")
    @Test
    void printBenefitDetails(){
        // when
        OutputView.printBenefitDetails();

        // then
        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("크리스마스 디데이 할인: -1,200원");
    }

    @DisplayName("혜택이 없을 경우, 없음 출력")
    @Test
    void printBenefitDetailsByNotApplicable(){
        // when
        OutputView.printBenefitDetails();

        // then
        assertThat(out.toString())
                .contains("<혜택 내역>")
                .contains("없음");
    }

    @DisplayName("총 헤택 금액 출력")
    @Test
    void printTotalBenefitAmount(){
        // when
        OutputView.printTotalBenefitAmount();

        // then
        assertThat(out.toString())
                .contains("<총혜택 금액>")
                .contains("-31,246원");
    }

    @DisplayName("혜택 금액이 없을 경우, 0원 출력")
    @Test
    void printTotalBenefitAmountByZero(){
        // when
        OutputView.printTotalBenefitAmount();

        // then
        assertThat(out.toString())
                .contains("<총혜택 금액>")
                .contains("0원");
    }

    @DisplayName("할인 후 예상 결제 금액 출력")
    @Test
    void printPaymentAmount(){
        // when
        OutputView.printPaymentAmount();

        // then
        assertThat(out.toString())
                .contains("<할인 후 예상 결제 금액>")
                .contains("8,500원");
    }

    @DisplayName("혜택 금액에 따라 이벤트 배지 출력")
    @Test
    void printBadge(){
        // when
        OutputView.printBadg();

        // then
        assertThat(out.toString())
                .contains("<12월 이벤트 배지>")
                .contains("산타");
    }
}
