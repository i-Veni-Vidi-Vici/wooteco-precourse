package domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Food;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @DisplayName("주문 메뉴에서 애피타이저 개수 체크")
    @Test
    void checkAppetizer() {
        Map<Food, Integer> orderedMenu = new HashMap<>();

        orderedMenu.put(Food.MUSHROOM_SOUP, 1);
        orderedMenu.put(Food.CAESAR_SALAD, 2);

        orderedMenu.put(Food.T_BONE_STEAK, 3);
        orderedMenu.put(Food.CHOCO_CAKE, 1);
        orderedMenu.put(Food.ZERO_COLA, 3);

        assertThat(Order.checkAppetizer(orderedMenu)).isEqualTo(3);
    }
}
