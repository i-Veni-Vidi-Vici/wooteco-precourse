package menu.view;

import static menu.constants.Message.CATEGORY;
import static menu.constants.Message.COMPLETION;
import static menu.constants.Message.DAY_OF_THE_WEEK;
import static menu.constants.Message.RECOMMENDATIONS;
import static menu.constants.Message.START;
import static menu.constants.Symbol.LEFT_SQUARE_BRACKET;
import static menu.constants.Symbol.RIGHT_SQUARE_BRACKET;
import static menu.constants.Symbol.VERTICAL_BAR;
import static menu.constants.Symbol.WHITESPACE;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printError(String error) {
        System.out.println(error);
    }

    public void printStart() {
        System.out.println(START.getMessage());
    }

    public void printRecommendations(List<String> categories, Map<String, List<String>> recommendations) {
        System.out.println(RECOMMENDATIONS.getMessage());
        System.out.println(DAY_OF_THE_WEEK.getMessage());
        printCategory(categories);

        for (String coach : recommendations.keySet()) {
            System.out.print(LEFT_SQUARE_BRACKET.get() + WHITESPACE.get() + coach + WHITESPACE.get()
                    + VERTICAL_BAR.get() + WHITESPACE.get());

            System.out.print(String.join(WHITESPACE.get() + VERTICAL_BAR.get()
                    + WHITESPACE.get(), recommendations.get(coach)));
            System.out.println(WHITESPACE.get() + RIGHT_SQUARE_BRACKET.get());
        }
    }

    private void printCategory(List<String> categories) {
        System.out.print(LEFT_SQUARE_BRACKET.get() + WHITESPACE.get() + CATEGORY.getMessage()
                + WHITESPACE.get() + VERTICAL_BAR.get() + WHITESPACE.get());
        System.out.print(String.join(WHITESPACE.get() + VERTICAL_BAR.get() + WHITESPACE.get(), categories));
        System.out.println(WHITESPACE.get() + RIGHT_SQUARE_BRACKET.get());
    }

    public void printCompletion() {
        System.out.println(COMPLETION.getMessage());
    }
}
