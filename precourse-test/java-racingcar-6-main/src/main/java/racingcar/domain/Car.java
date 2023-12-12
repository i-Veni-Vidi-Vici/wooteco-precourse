package racingcar.domain;

import static racingcar.constants.Symbol.HYPHEN;
import static racingcar.constants.Value.MAX_CAR_NAME_LENGTH;
import static racingcar.constants.Value.MAX_RANDOM_NUMBER;
import static racingcar.constants.Value.MIN_CAR_COUNT;
import static racingcar.constants.Value.MIN_FORWARD_CONDITION;
import static racingcar.constants.Value.MIN_RANDOM_NUMBER;

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
            if (carName.length() > MAX_CAR_NAME_LENGTH.get()) {
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
        if (car.size() < MIN_CAR_COUNT.get()) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        for (String carName : car.keySet()) {
            if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.get(), MAX_RANDOM_NUMBER.get())
                    >= MIN_FORWARD_CONDITION.get()) {
                car.replace(carName, (car.get(carName) + HYPHEN.get()));
            }
        }
    }

    public Map<String, String> get() {
        return Collections.unmodifiableMap(car);
    }
}
