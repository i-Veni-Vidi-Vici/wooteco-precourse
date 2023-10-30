package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    public List<String> movedDistances;
    public List<String> names;

    public Car(List<String> names) {
        this.names = names;
        validateCarNames(this.names);
        trimCarNames(this.names);
        initializeMovedDistances();
    }

    private void initializeMovedDistances() {
        movedDistances = new ArrayList<>(Collections.nCopies(this.names.size(), ""));
    }

    private void validateCarNames(List<String> carNames) {
        Validator.checkCarCount(carNames);
        Validator.checkBlank(carNames);
        Validator.checkLength(carNames);
        Validator.checkDuplication(carNames);
    }

    private void trimCarNames(List<String> carNames) {
        carNames.replaceAll(String::trim);
    }

    public void move(int roundCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < roundCount; i++) {
            moveRandomly();
            printDistances();
        }

    }

    private void moveRandomly() {

        for (int j = 0; j < movedDistances.size(); j++) {

            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                movedDistances.set(j, movedDistances.get(j) + "-");
            }

        }

    }

    private void printDistances() {

        for (int k = 0; k < names.size(); k++) {
            System.out.println(names.get(k) + " : " + movedDistances.get(k));
        }

        System.out.println();
    }
}
