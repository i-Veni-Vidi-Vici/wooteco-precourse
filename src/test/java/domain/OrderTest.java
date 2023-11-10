package domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Food;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {
    private static Map<Food, Integer> orderedMenu;

    @BeforeAll
    static void beforeAll() {
        orderedMenu = new HashMap<>();

        // 애피타이저 - 3, 22,000원
        orderedMenu.put(Food.MUSHROOM_SOUP, 1);
        orderedMenu.put(Food.CAESAR_SALAD, 2);
        // 메인 - 4, 189,000원
        orderedMenu.put(Food.T_BONE_STEAK, 2);
        orderedMenu.put(Food.BBQ_RIBS, 1);
        orderedMenu.put(Food.CHRISTMAS_PASTA, 1);
        // 디저트 - 2, 20,000원
        orderedMenu.put(Food.CHOCO_CAKE, 1);
        orderedMenu.put(Food.ICE_CREAM, 1);
        // 음료 -3, 88,000원
        orderedMenu.put(Food.ZERO_COLA, 1);
        orderedMenu.put(Food.RED_WINE, 1);
        orderedMenu.put(Food.CHAMPAGNE, 1);

        // 총 주문 금액: 319,000원
    }

    @DisplayName("주문 메뉴에서 애피타이저 개수 체크")
    @Test
    void checkAppetizer() {
        assertThat(Order.checkAppetizer(orderedMenu)).isEqualTo(3);
    }

    @DisplayName("주문 메뉴에서 메인 개수 체크")
    @Test
    void checkMain() {
        assertThat(Order.checkMain(orderedMenu)).isEqualTo(4);
    }

    @DisplayName("주문 메뉴에서 디저트 개수 체크")
    @Test
    void checkDessert() {
        assertThat(Order.checkDessert(orderedMenu)).isEqualTo(2);
    }

    @DisplayName("주문 메뉴에서 음료 개수 체크")
    @Test
    void checkDrink() {
        assertThat(Order.checkDrink(orderedMenu)).isEqualTo(3);
    }


    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateTotalAmount() {
        assertThat(Order.calculateTotalAmount(orderedMenu)).isEqualTo(319000);
    }

    @DisplayName("총 주문 금액에서 할인 후 금액 반환")
    @Test
    void discount() {
        assertThat(Order.discount(10000, 2000).isEqualTo(8000);
    }
}
