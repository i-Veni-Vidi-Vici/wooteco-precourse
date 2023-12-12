package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void createCar() {
        assertDoesNotThrow(() -> new Car(Map.of("12345", "", "123", "")));
    }

    @DisplayName("이름이 5자 초과일 때, 예외 처리")
    @Test
    void checkLength() {
        assertThatThrownBy(() -> new Car(Map.of("123456", "", "12334567", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 공백일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "  "})
    void checkBlank(String name) {
        assertThatThrownBy(() -> new Car(Map.of(name, "", "123", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한대 이하 일 때, 예외 처리")
    @Test
    void checkCount() {
        assertThatThrownBy(() -> new Car(Map.of("pobi", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("자동차 이동")
//    @Test
//    void move() {
//        Car car = new Car(Map.of("pobi", "", "woni", ""));
//
//        assertThat().isEqualTo();
//    }
}
