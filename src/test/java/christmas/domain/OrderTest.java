package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Food;
import christmas.domain.promotion.Benefits;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
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


    @DisplayName("주문 메뉴에서 메인 개수 체크")
    @Test
    void checkMain() {
        assertThat(reservedMenu.countMain()).isEqualTo(4);
    }

    @DisplayName("주문 메뉴에서 디저트 개수 체크")
    @Test
    void checkDessert() {
        assertThat(reservedMenu.countDessert()).isEqualTo(2);
    }

    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateTotalAmount() {
        assertThat(reservedMenu.calculateTotalAmount()).isEqualTo(319000);
    }

//    @DisplayName("총 주문 금액에서 할인 후 금액 반환")
//    @Test
//    void discount() {
//        assertThat(Benefits.discount(10000, 2000)).isEqualTo(8000);
//    }
}
