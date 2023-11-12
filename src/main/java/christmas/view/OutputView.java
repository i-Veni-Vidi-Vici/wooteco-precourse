package christmas.view;

import christmas.constants.Badge;
import christmas.constants.Benefit;
import christmas.constants.Food;
import java.util.Map;

public class OutputView {

    public static void printPlanner() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDate(Integer date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenu(Map<Food, Integer> orderedMenu) {
        System.out.println("<주문 메뉴>");

        for (Food food : orderedMenu.keySet()) {
            System.out.println(food.getName() + " " + orderedMenu.get(food) + "개");
        }

        System.out.println();
    }

    public static void printTotalAmount(Integer totalAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", totalAmount) + "원");
        System.out.println();
    }


    public static void printFreeGift(boolean freeGift) {
        System.out.println("<증정 메뉴>");

        if (freeGift) {
            System.out.println("샴페인 1개");
        }
        if (!freeGift) {
            System.out.println("없음");
        }

        System.out.println();
    }

    public static void printBenefitDetails(Map<Benefit, Integer> benefits) {
        System.out.println("<혜택 내역>");

        for (Benefit benefit : benefits.keySet()) {
            System.out.println(benefit.getBenefit() + ": -" + String.format("%,d", benefits.get(benefit)) + "원");
        }

        if (benefits.isEmpty()) {
            System.out.println("없음");
        }

        System.out.println();
    }

    public static void printTotalBenefitAmount(Integer totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + String.format("%,d", totalBenefitAmount) + "원");
        System.out.println();
    }

    public static void printPaymentAmount(Integer paymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d", paymentAmount) + "원");
        System.out.println();
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getBadge());
    }
}
