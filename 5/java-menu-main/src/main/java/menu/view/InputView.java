package menu.view;

import static menu.constants.Message.COACHES_INPUT;
import static menu.constants.Message.INEDIBLE_MENU_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCoaches() {
        System.out.println(COACHES_INPUT.getMessage());
        return Console.readLine();
    }

    public String getInedibleMenu(String coach) {
        System.out.println(coach + INEDIBLE_MENU_INPUT.getMessage());
        return Console.readLine();
    }
}
