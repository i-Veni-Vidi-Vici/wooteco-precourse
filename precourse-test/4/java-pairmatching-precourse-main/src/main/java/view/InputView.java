package view;

import static pairmatching.constants.FunctionValue.FAIR_INITIALIZATION;
import static pairmatching.constants.FunctionValue.FAIR_MATCHING;
import static pairmatching.constants.FunctionValue.FAIR_SEARCH;
import static pairmatching.constants.FunctionValue.QUIT;
import static pairmatching.constants.Message.FUNCTION_INPUT;
import static pairmatching.constants.Message.INFORMATION_FORM_INPUT;
import static pairmatching.constants.Message.INFORMATION_INPUT;
import static pairmatching.constants.Message.NEW_MATCHING_INPUT;
import static pairmatching.constants.Message.YES_OR_NO_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getFunction() {
        System.out.println(FUNCTION_INPUT.getMessage());
        System.out.println(FAIR_MATCHING.getMessage());
        System.out.println(FAIR_SEARCH.getMessage());
        System.out.println(FAIR_INITIALIZATION.getMessage());
        System.out.println(QUIT.getMessage());
        return Console.readLine();
    }

    public String getInformation() {
        System.out.println(INFORMATION_INPUT.getMessage());
        System.out.println(INFORMATION_FORM_INPUT.getMessage());
        return Console.readLine();
    }

    public String getNewMatching() {
        System.out.println(NEW_MATCHING_INPUT.getMessage());
        System.out.println(YES_OR_NO_INPUT.getMessage());
        return Console.readLine();
    }
}
