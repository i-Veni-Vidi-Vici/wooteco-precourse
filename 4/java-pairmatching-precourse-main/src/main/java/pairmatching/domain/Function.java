package pairmatching.domain;

import java.util.Arrays;

public class Function {
    private String function;

    public Function(String function) {
        checkFunction(function);
        this.function = function;
    }

    private void checkFunction(String function){
        if (!Arrays.asList("1", "2", "3", "Q").contains(function)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String get() {
        return function;
    }
}
