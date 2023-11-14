package christmas.view;

import static christmas.constants.Message.DATE_INPUT;
import static christmas.constants.Message.MENU_INPUT;

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
        System.out.println("우테코 메뉴를 보기 원하시면 1번, 원치 않으시면 2번을 눌러주세요.");
        return Console.readLine();
    }
}
