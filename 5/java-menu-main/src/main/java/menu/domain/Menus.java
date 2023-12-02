package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.constants.Menu;

public class Menus {

    private final Map<String, List<String>> menus;

    public Menus() {
        menus = new LinkedHashMap<>();
        for (Menu menu : Menu.values()) {
            List<String> menuList = menus.getOrDefault(menu.getCategory(), new ArrayList<>());
            menuList.add(menu.getMenu());

            menus.put(menu.getCategory(), menuList);
        }
    }

    public List<String> recommend(List<String> categories, List<String> inedibleMenus) {
        List<String> recommendedMenus = new ArrayList<>();

        for (String category : categories) {
            checkMenu(recommendedMenus, category, inedibleMenus);
        }

        return recommendedMenus;
    }

    private void checkMenu(List<String> recommendedMenus, String category, List<String> inedibleMenus) {
        while (true) {
            String menu = Randoms.shuffle(menus.get(category)).get(0);

            if (!recommendedMenus.contains(menu) && !inedibleMenus.contains(menu)) {
                recommendedMenus.add(menu);
                break;
            }
        }
    }

}
