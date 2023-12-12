package lotto.view;

import static lotto.constants.Message.BONUS_NUMBER_INPUT;
import static lotto.constants.Message.MONEY_INPUT;
import static lotto.constants.Message.WINNING_NUMBER_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getMoney() {
        System.out.println(MONEY_INPUT.getMessage());
        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }
}
