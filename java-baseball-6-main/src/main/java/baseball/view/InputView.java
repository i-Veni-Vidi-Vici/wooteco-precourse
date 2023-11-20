package baseball.view;

import static baseball.constants.Message.RESTART_NUMBER_INPUT;
import static baseball.constants.Message.THREE_NUMBER_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getThreeNumber() {
        System.out.print(THREE_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }

    public String getRestartNumber() {
        System.out.println(RESTART_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }
}
