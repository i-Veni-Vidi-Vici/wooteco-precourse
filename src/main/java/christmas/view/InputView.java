package christmas.view;

import static christmas.constants.Message.DATE_INPUT;
import static christmas.constants.Message.MENU;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getDate() {
        System.out.println(DATE_INPUT.getMessage());
        return Console.readLine();
    }

    public String getMenu() {
        System.out.println(MENU.getMessage());
        return Console.readLine();
    }
}
