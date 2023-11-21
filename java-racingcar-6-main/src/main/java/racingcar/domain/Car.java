package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Map;

public class Car {
    private final Map<String, String> car;

    public Car(Map<String, String> car) {
        checkLength(car);
        checkBlank(car);
        checkCount(car);
        this.car = car;
    }

    private void checkLength(Map<String, String> car) {
        for (String carName : car.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkBlank(Map<String, String> car) {
        for (String carName : car.keySet()) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkCount(Map<String, String> car) {
        if (car.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        for (String carName : car.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.replace(carName, (car.get(carName) + "-"));
            }
        }
    }

    public Map<String, String> get() {
        return Collections.unmodifiableMap(car);
    }
}
