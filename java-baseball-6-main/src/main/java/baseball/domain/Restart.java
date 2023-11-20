package baseball.domain;

public class Restart {

    private final Integer restartNumber;

    public Restart(Integer restartNumber) {
        checkRange(restartNumber);
        this.restartNumber = restartNumber;
    }
    public boolean isRestart() {
        if(restartNumber == 1){
            return true;
        }
        if (restartNumber == 2) {
            return false;
        }

        return false;
    }

    private void checkRange(Integer restartNumber){
        if ((restartNumber !=1) && (restartNumber != 2)) {
            throw new IllegalArgumentException();
        }
    }
}
