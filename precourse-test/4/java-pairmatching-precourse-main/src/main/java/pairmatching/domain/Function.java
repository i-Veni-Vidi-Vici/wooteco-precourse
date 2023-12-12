package pairmatching.domain;

import static pairmatching.constants.Error.FUNCTION_ERROR;
import static pairmatching.constants.FunctionValue.FAIR_INITIALIZATION;
import static pairmatching.constants.FunctionValue.FAIR_MATCHING;
import static pairmatching.constants.FunctionValue.FAIR_SEARCH;
import static pairmatching.constants.FunctionValue.QUIT;

import java.util.Arrays;

public class Function {
    private String function;

    public Function(String function) {
        checkFunction(function);
        this.function = function;
    }

    private void checkFunction(String function) {
        if (!Arrays.asList(FAIR_MATCHING.get(), FAIR_SEARCH.get(), FAIR_INITIALIZATION.get(), QUIT.get())
                .contains(function)) {
            throw new IllegalArgumentException(FUNCTION_ERROR.getMessage());
        }
    }

    public String get() {
        return function;
    }
}
