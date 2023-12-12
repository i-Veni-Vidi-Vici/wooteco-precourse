package bridge.view;

import static bridge.constants.Message.BRIDGE_LENGTH_INPUT;
import static bridge.constants.Message.DIRECTION_INPUT;
import static bridge.constants.Message.RETRY_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getBridgeLength() {
        System.out.println(BRIDGE_LENGTH_INPUT.getMessage());
        return Console.readLine();
    }

    public String getDirection() {
        System.out.println(DIRECTION_INPUT.getMessage());
        return Console.readLine();
    }

    public String getRetry() {
        System.out.println(RETRY_INPUT.getMessage());
        return Console.readLine();
    }
}
