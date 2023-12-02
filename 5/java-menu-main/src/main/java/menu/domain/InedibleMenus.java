package menu.domain;

import static menu.constants.Error.MENU_COUNT_ERROR;
import static menu.constants.Error.MENU_DUPLICATION_ERROR;
import static menu.constants.Error.NON_EXISTENT_MENU_ERROR;
import static menu.constants.Value.MAX_MENU_COUNT;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import menu.constants.Menu;

public class InedibleMenus {

    private final List<String> inedibleMenus;

    public InedibleMenus(List<String> inedibleMenus) {
        checkCount(inedibleMenus);
        checkDuplication(inedibleMenus);
        checkMenu(inedibleMenus);
        this.inedibleMenus = inedibleMenus;
    }

    private void checkCount(List<String> inedibleMenus) {
        if (inedibleMenus.size() > MAX_MENU_COUNT.get()) {
            throw new IllegalArgumentException(MENU_COUNT_ERROR.getMessage());
        }
    }

    private void checkDuplication(List<String> inedibleMenus) {
        if (new HashSet<>(inedibleMenus).size() != inedibleMenus.size()) {
            throw new IllegalArgumentException(MENU_DUPLICATION_ERROR.getMessage());
        }
    }

    private void checkMenu(List<String> inedibleMenus) {
        for (String inedibleMenu : inedibleMenus) {
            if (!Menu.checkExistence(inedibleMenu)) {
                throw new IllegalArgumentException(NON_EXISTENT_MENU_ERROR.getMessage());
            }
        }
    }

    public List<String> get() {
        return Collections.unmodifiableList(inedibleMenus);
    }
}
