package domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Order;
import java.util.HashMap;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OrderTest {


    @ParameterizedTest
    @CsvSource(value = {"양송이수프,1","타파스,2","시저샐러드,3", "티본스테이크,1","초코케이크,1"})
    void checkAppetizer(Food orderedFood, Integer foodCount){
        Map<Food, Integer> orderedMenu = new HashMap<>();

        orderedMenu.put(orderedFood,foodCount);

        assertThat(Order.checkAppetizer(orderedMenu)).isEqualTo(foodCount);
    }
}
