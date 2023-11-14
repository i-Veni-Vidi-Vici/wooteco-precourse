package christmas.domain;

public class MenuOption {

    private final Integer menuOption;

    public MenuOption(Integer menuOption) {
        checkOption(menuOption);
        this.menuOption = menuOption;
    }

    private void checkOption(Integer menuOption) {
        if ((menuOption != 1) && (menuOption != 2)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOption() {
        return (menuOption == 1);
    }
}
