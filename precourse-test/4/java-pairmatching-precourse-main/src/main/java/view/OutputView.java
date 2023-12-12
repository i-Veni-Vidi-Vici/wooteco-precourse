package view;

import static pairmatching.constants.Message.COURSE;
import static pairmatching.constants.Message.HASH;
import static pairmatching.constants.Message.INITIALIZATION;
import static pairmatching.constants.Message.LEVEL_FIVE;
import static pairmatching.constants.Message.LEVEL_FOUR;
import static pairmatching.constants.Message.LEVEL_ONE;
import static pairmatching.constants.Message.LEVEL_THREE;
import static pairmatching.constants.Message.LEVEL_TWO;
import static pairmatching.constants.Message.MISSION;
import static pairmatching.constants.Message.NOTHING;
import static pairmatching.constants.Message.PAIR_RESULT;
import static pairmatching.constants.Symbol.COLON;
import static pairmatching.constants.Symbol.WHITESPACE;
import static pairmatching.constants.Value.INITIAL_ZERO;
import static pairmatching.constants.Value.REMAINDER_ONE;
import static pairmatching.constants.Value.REMAINDER_ZERO;
import static pairmatching.constants.Value.SECOND_INDEX;
import static pairmatching.constants.Value.THIRD_INDEX;
import static pairmatching.constants.Value.THREE;
import static pairmatching.constants.Value.TWO;

import java.util.List;

public class OutputView {

    public void printError(String error) {
        System.out.println(error);
    }

    public void printInformation() {
        System.out.println(HASH.getMessage());
        System.out.println(COURSE.getMessage());
        System.out.println(MISSION.getMessage());
        System.out.println(LEVEL_ONE.getMessage());
        System.out.println(LEVEL_TWO.getMessage());
        System.out.println(LEVEL_THREE.getMessage());
        System.out.println(LEVEL_FOUR.getMessage());
        System.out.println(LEVEL_FIVE.getMessage());
        System.out.println(HASH.getMessage());
    }

    public void printResult(List<String> crews) {
        System.out.println(PAIR_RESULT.getMessage());

        if (crews.isEmpty()) {
            printNothing();
            return;
        }
        if (crews.size() % TWO.get() == REMAINDER_ZERO.get()) {
            printEvenCrews(crews);
        }
        if (crews.size() % TWO.get() == REMAINDER_ONE.get()) {
            printOddCrews(crews);
        }
    }

    private void printNothing() {
        System.out.println(NOTHING.getMessage());
    }

    private void printEvenCrews(List<String> crews) {
        for (int index = INITIAL_ZERO.get(); index < crews.size(); index += TWO.get()) {
            System.out.println(
                    crews.get(index) + WHITESPACE.get() + COLON.get() + WHITESPACE.get() + crews.get(
                            index + SECOND_INDEX.get()));
        }
    }

    private void printOddCrews(List<String> crews) {
        for (int index = INITIAL_ZERO.get(); index < crews.size(); index += TWO.get()) {
            if (index == crews.size() - THREE.get()) {
                System.out.println(
                        crews.get(index) + WHITESPACE.get() + COLON.get() + WHITESPACE.get() + crews.get(
                                index + SECOND_INDEX.get())
                                + WHITESPACE.get() + COLON.get() + WHITESPACE.get() + crews.get(
                                index + THIRD_INDEX.get()));
                return;
            }
            System.out.println(
                    crews.get(index) + WHITESPACE.get() + COLON.get() + WHITESPACE.get() + crews.get(
                            index + SECOND_INDEX.get()));
        }
    }

    public void printInitialization() {
        System.out.println(INITIALIZATION.getMessage());
    }
}
