package christmas.view;

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
            System.out.println(food + " " + orderedMenu.get(food) + "개");
        }

        System.out.println();
    }

    public static void printTotalAmount(Integer totalAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalAmount + "원\n");
    }


    public static void printFreeGift(boolean freeGift) {
        System.out.println("<증정 메뉴>");

        if (freeGift) {
            System.out.println("샴페인 1개");
        }

        System.out.println("없음");
    }

    public static void printBenefitDetails() {
        System.out.println("<혜택 내역>");

    }
}
