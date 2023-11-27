package christmas.view;

import christmas.constants.Badge;
import christmas.constants.Benefit;
import christmas.constants.Food;
import java.util.Map;

public class OutputView {
    public void printPlanner() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(Integer date) {
        System.out.println("12월" + " " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu(Map<Food, Integer> reservedMenu) {
        System.out.println("<주문 메뉴>");

        for (Food food : reservedMenu.keySet()) {
            System.out.println(food.getName() + " " + reservedMenu.get(food) + "개");
        }
    }

    public void printAmount(Integer amount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", amount) + "원");
    }

    public void printGiveaway(boolean hasGiveaway) {
        System.out.println("<증정 메뉴>");

        if (hasGiveaway) {
            System.out.println("샴페인 1개");
            return;
        }

        System.out.println("없음");
    }


    public void printBenefits(Map<Benefit, Integer> benefits) {
        System.out.println("<혜택 내역>");

        if (benefits.isEmpty()) {
            System.out.println("없음");
            return;
        }

        for (Benefit benefit : benefits.keySet()) {
            System.out.println(benefit.get() + ":" + " " + "-" + String.format("%,d", benefits.get(benefit)) + "원");
        }
    }

    public void printBenefitAmount(Integer benefitAmount) {
        System.out.println("<총혜택 금액>");

        if (benefitAmount > 0) {
            System.out.println("-" + String.format("%,d", benefitAmount) + "원");
            return;
        }

        System.out.println("0원");
    }

    public void printPaymentAmount(Integer paymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d", paymentAmount) + "원");
    }

    public void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.get());
    }
}
