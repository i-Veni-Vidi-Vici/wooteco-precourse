package bridge.view;

import static bridge.constants.Message.BELOW_BRIDGE;
import static bridge.constants.Message.FAILURE;
import static bridge.constants.Message.SUCCESS;
import static bridge.constants.Message.WRONG;
import static bridge.constants.Message.RESULT;
import static bridge.constants.Message.RETRY_COUNT;
import static bridge.constants.Message.START_GAME;
import static bridge.constants.Message.SUCCESS_RESULT;
import static bridge.constants.Message.UPPER_BRIDGE;
import static bridge.constants.Symbol.EMPTY;
import static bridge.constants.Symbol.LEFT_SQUARE_BRACKET;
import static bridge.constants.Symbol.RIGHT_SQUARE_BRACKET;
import static bridge.constants.Symbol.VERTICAL_BAR;
import static bridge.constants.Symbol.WHITESPACE;
import static bridge.constants.Value.FIRST_INDEX;
import static bridge.constants.Value.ONE_LENGTH;
import static bridge.constants.Value.SECOND_INDEX;

import java.util.List;

public class OutputView {
    public void printStart() {
        System.out.println(START_GAME.getMessage());
    }

    public void printMap(List<List<String>> result) {
        printOneMap(result, UPPER_BRIDGE.getMessage());
        printOneMap(result, BELOW_BRIDGE.getMessage());
    }

    private void printOneMap(List<List<String>> result, String direction) {
        StringBuilder oneMap = new StringBuilder(LEFT_SQUARE_BRACKET.get());

        for (List<String> stage : result) {
            oneMap.append(createVerticalBar(oneMap.length())).append(expressMap(stage, direction));
        }

        oneMap.append(RIGHT_SQUARE_BRACKET.get());
        System.out.println(oneMap);
    }

    private String createVerticalBar(Integer length){
        if (length > ONE_LENGTH.get()) {
            return VERTICAL_BAR.get();
        }

        return EMPTY.get();
    }

    private String expressMap(List<String> stage, String direction) {
        if (stage.get(FIRST_INDEX.get()).equals(direction)) {
            return (WHITESPACE.get() + stage.get(SECOND_INDEX.get()) + WHITESPACE.get());
        }

        return (WHITESPACE.get() + WHITESPACE.get() + WHITESPACE.get());
    }

    public void printResult(List<List<String>> result, Integer retryCount) {
        System.out.println(RESULT.getMessage());
        printMap(result);

        System.out.println(SUCCESS_RESULT.getMessage() + calculateResult(result));
        System.out.println(RETRY_COUNT.getMessage() + retryCount);
    }

    private String calculateResult(List<List<String>> result) {
        for (List<String> stage : result) {
            if (stage.contains(WRONG.getMessage())) {
                return FAILURE.getMessage();
            }
        }

        return SUCCESS.getMessage();
    }

    public void printError(String error) {
        System.out.println(error);
    }
}
