package baseball;

import baseball.domain.Comparator;
import baseball.domain.ComputerNumber;
import baseball.domain.Restart;
import baseball.domain.UserNumber;
import baseball.util.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    private final OutputView outputView;
    private final InputView inputView;

    public GameManager() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    void run() {
        outputView.printStart();
        Restart restart;

        do {
            matchNumber();
            restart = new Restart(Converter.convertToNumber(inputView.getRestartNumber()));
        } while (restart.isRestart());
    }

    void matchNumber() {
        ComputerNumber computerNumber = new ComputerNumber();
        Comparator comparator = new Comparator();
        System.out.println(computerNumber.get());
        boolean isRunning = true;

        while (isRunning) {
            UserNumber userNumber = new UserNumber(Converter.convertToList(inputView.getThreeNumber()));
            Integer strikeCount = comparator.calculateStrike(userNumber.get(), computerNumber.get());
            outputView.printResult(comparator.calculateBall(userNumber.get(), computerNumber.get()),strikeCount);
            if (strikeCount == 3) {
                outputView.printExit();
                isRunning = false;
            }
        }
    }
}
