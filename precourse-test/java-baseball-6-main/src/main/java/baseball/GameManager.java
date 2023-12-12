package baseball;

import static baseball.constants.Value.THREE_STRIKE;

import baseball.domain.Comparator;
import baseball.domain.ComputerNumber;
import baseball.domain.Restart;
import baseball.domain.UserNumber;
import baseball.utility.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    private final OutputView outputView;
    private final InputView inputView;
    private final Converter converter;

    public GameManager() {
        outputView = new OutputView();
        inputView = new InputView();
        converter = new Converter();
    }

    public void run() {
        outputView.printStart();
        Restart restart;

        do {
            matchNumber();
            restart = new Restart(converter.convertToNumber(inputView.getRestartNumber()));
        } while (restart.isRestart());
    }

    private void matchNumber() {
        ComputerNumber computerNumber = new ComputerNumber();
        Comparator comparator = new Comparator();
        boolean isRunning = true;

        while (isRunning) {
            UserNumber userNumber = new UserNumber(converter.convertToList(inputView.getThreeNumber()));
            Integer strikeCount = comparator.calculateStrike(userNumber.get(), computerNumber.get());
            outputView.printResult(comparator.calculateBall(userNumber.get(), computerNumber.get()), strikeCount);
            isRunning = isRun(strikeCount);
        }
    }

    private boolean isRun(Integer strikeCount) {
        if (strikeCount.equals(THREE_STRIKE.get())) {
            outputView.printExit();
            return false;
        }

        return true;
    }
}
