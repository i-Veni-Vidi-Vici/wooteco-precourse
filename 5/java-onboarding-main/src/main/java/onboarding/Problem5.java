package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Bank bank = new Bank();
        return bank.withdraw(money);
    }
}
