package baseball.view;

import static baseball.constants.Message.BALL;
import static baseball.constants.Message.EXIT;
import static baseball.constants.Message.NOTHING;
import static baseball.constants.Message.START_BASEBALL_GAME;
import static baseball.constants.Message.STRIKE;
import static baseball.constants.Message.WHITESPACE;
import static baseball.constants.Value.ZERO;

public class OutputView {

    public void printStart() {
        System.out.println(START_BASEBALL_GAME.getMessage());
    }

    public void printResult(Integer ballCount, Integer strikeCount) {
        if (ballCount > ZERO.get()) {
            System.out.print(ballCount + BALL.getMessage() + WHITESPACE.getMessage());
        }
        if (strikeCount > ZERO.get()) {
            System.out.print(strikeCount + STRIKE.getMessage());
        }
        if ((ballCount + strikeCount) == ZERO.get()) {
            System.out.print(NOTHING.getMessage());
        }

        System.out.println();
    }

    public void printExit() {
        System.out.println(EXIT.getMessage());
    }
}
