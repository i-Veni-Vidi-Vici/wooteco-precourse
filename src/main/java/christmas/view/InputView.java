package christmas.view;

import static christmas.constants.Message.DATE_INPUT;
import static christmas.constants.Message.MENU_INPUT;
import static christmas.constants.Message.MENU_OPTION_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getDate() {
        System.out.println(DATE_INPUT.getMessage());
        return Console.readLine();
    }

    public String getMenu() {
        System.out.println(MENU_INPUT.getMessage());
        return Console.readLine();
    }


    public String getMenuOption() {
        // given
        System.out.println(MENU_OPTION_INPUT.getMessage());
        return Console.readLine();
    }
}
