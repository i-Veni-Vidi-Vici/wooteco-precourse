package menu.domain;

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
        if (inedibleMenus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴 개수는 2개이하 이어야 합니다.");
        }
    }

    private void checkDuplication(List<String> inedibleMenus) {
        if (new HashSet<>(inedibleMenus).size() != inedibleMenus.size()) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴가 중복됩니다.");
        }
    }

    private void checkMenu(List<String> inedibleMenus) {
        for (String inedibleMenu : inedibleMenus) {
            if (!Menu.checkExistence(inedibleMenu)) {
                throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴가 존재하지 않습니다.");
            }
        }
    }

    public List<String> get() {
        return Collections.unmodifiableList(inedibleMenus);
    }
}
