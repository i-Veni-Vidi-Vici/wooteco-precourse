package baseball.domain;

import static baseball.constants.Value.EXIT_NUMBER;
import static baseball.constants.Value.RESTART_NUMBER;

public class Restart {

    private final Integer restartNumber;

    public Restart(Integer restartNumber) {
        checkRange(restartNumber);
        this.restartNumber = restartNumber;
    }

    public boolean isRestart() {
        if (restartNumber.equals(RESTART_NUMBER.get())) {
            return true;
        }
        if (restartNumber.equals(EXIT_NUMBER.get())) {
            return false;
        }

        return false;
    }

    private void checkRange(Integer restartNumber) {
        if ((!restartNumber.equals(RESTART_NUMBER.get())) && (!restartNumber.equals(EXIT_NUMBER.get()))) {
            throw new IllegalArgumentException();
        }
    }
}
