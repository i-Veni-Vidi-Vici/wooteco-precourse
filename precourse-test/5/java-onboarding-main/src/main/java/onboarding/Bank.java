package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public List<Integer> withdraw(Integer money) {
        List<Integer> count = new ArrayList<>();

        count.add(money / 50000);
        money %= 50000;

        count.add(money / 10000);
        money %= 10000;

        count.add(money / 5000);
        money %= 5000;

        count.add(money / 1000);
        money %= 1000;

        count.add(money / 500);
        money %= 500;

        count.add(money / 100);
        money %= 100;

        count.add(money / 50);
        money %= 50;

        count.add(money / 10);
        count.add(money %10);

        return count;
    }
}
