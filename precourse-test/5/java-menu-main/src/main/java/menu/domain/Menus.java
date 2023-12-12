package menu.domain;

import static menu.constants.Value.FIRST_INDEX;

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

    public Map<String, List<String>> recommend(List<String> categories, Map<String, InedibleMenus> inedibleMenus) {
        Map<String, List<String>> recommendedMenus = initialize(inedibleMenus);

        for (String category : categories) {
            addMenu(recommendedMenus, category, inedibleMenus);
        }

        return recommendedMenus;
    }

    private Map<String, List<String>> initialize(Map<String, InedibleMenus> inedibleMenus) {
        Map<String, List<String>> recommendedMenus = new LinkedHashMap<>();

        for (String coach : inedibleMenus.keySet()) {
            recommendedMenus.put(coach, new ArrayList<>());
        }

        return recommendedMenus;
    }

    private void addMenu(Map<String, List<String>> recommendedMenus, String category,
                         Map<String, InedibleMenus> inedibleMenus) {
        for (String coach : inedibleMenus.keySet()) {
            checkMenu(category, recommendedMenus.get(coach), inedibleMenus.get(coach).get());
        }
    }

    private void checkMenu(String category, List<String> recommendedMenus, List<String> inedibleMenus) {
        while (true) {
            String menu = Randoms.shuffle(menus.get(category)).get(FIRST_INDEX.get());

            if (!recommendedMenus.contains(menu) && !inedibleMenus.contains(menu)) {
                recommendedMenus.add(menu);
                break;
            }
        }
    }
}
