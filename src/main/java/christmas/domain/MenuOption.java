package christmas.domain;

import static christmas.constants.Value.MENU_SKIP_OPTION;
import static christmas.constants.Value.MENU_VIEW_OPTION;

public class MenuOption {

    private final Integer menuOption;

    public MenuOption(Integer menuOption) {
        checkOption(menuOption);
        this.menuOption = menuOption;
    }

    private void checkOption(Integer menuOption) {
        if ((!menuOption.equals(MENU_VIEW_OPTION.get())) && (!menuOption.equals(MENU_SKIP_OPTION.get()))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOption() {
        return (menuOption.equals(MENU_VIEW_OPTION.get()));
    }
}
