package racingcar.view;

import static racingcar.constants.Message.CAR_NAME_INPUT;
import static racingcar.constants.Message.ROUND_COUNT_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarName() {
        System.out.println(CAR_NAME_INPUT.getMessage());
        return Console.readLine();
    }

    public String getRoundCount() {
        System.out.println(ROUND_COUNT_INPUT.getMessage());
        return Console.readLine();
    }
}
