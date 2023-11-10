package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constants.Food;
import christmas.domain.OrderedMenu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderedMenuTest {

    private Map<Food, Integer> orderedMenu;

    @BeforeEach
    void beforEach() {
        orderedMenu = new HashMap<>();
    }

    @DisplayName("한 메뉴당 1개 이상 주문 안할 시, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkFoodCount(Integer foodCount) {
        // given
        orderedMenu.put(Food.MUSHROOM_SOUP, foodCount);

        // when, then
        assertThatThrownBy(() -> OrderedMenu.checkFoodCount(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
