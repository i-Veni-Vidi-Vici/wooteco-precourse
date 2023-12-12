package racingcar.view;

import static racingcar.constants.Message.RUN;
import static racingcar.constants.Message.WINNER;
import static racingcar.constants.Symbol.COLON;
import static racingcar.constants.Symbol.COMMA;
import static racingcar.constants.Symbol.WHITESPACE;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRun() {
        System.out.println(RUN.getMessage());
    }

    public void printResult(Map<String, String> car) {
        for (String carName : car.keySet()) {
            System.out.println(carName + WHITESPACE.get() + COLON.get() + WHITESPACE.get() + car.get(carName));
        }

        System.out.println();
    }


    public void printWinner(List<String> winners) {
        System.out.print(WINNER.getMessage());
        boolean isMany = false;

        for (String winner : winners) {
            if (isMany) {
                System.out.print(COMMA.get() + WHITESPACE.get());
            }

            System.out.print(winner);
            isMany = true;
        }
    }
}
