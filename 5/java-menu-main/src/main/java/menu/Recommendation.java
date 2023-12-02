package menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Categories;
import menu.domain.Coaches;
import menu.domain.InedibleMenus;
import menu.domain.Menus;
import menu.utility.Converter;
import menu.view.InputView;
import menu.view.OutputView;

public class Recommendation {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public Recommendation() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    void run() {
        outputView.printStart();
        Coaches coaches = createCoach();
        Map<String, InedibleMenus> inedibleMenus = createInedibleMenus(coaches);
        List<String> recommendedCategories = recommendCategories();

        outputView.printRecommendations(recommendedCategories,
                recommendMenus(recommendedCategories, inedibleMenus));

        outputView.printCompletion();
    }

    private Map<String, List<String>> recommendMenus(List<String> recommendedCategories,
                                                     Map<String, InedibleMenus> inedibleMenus) {
        Menus menus = new Menus();
        return menus.recommend(recommendedCategories, inedibleMenus);
    }

    private List<String> recommendCategories() {
        Categories categories = new Categories();
        return categories.recommend();
    }

    private Map<String, InedibleMenus> createInedibleMenus(Coaches coaches) {
        Map<String, InedibleMenus> inedibleMenus = new LinkedHashMap<>();

        for (String coach : coaches.get()) {
            inedibleMenus.put(coach, createInedibleMenus(coach));
        }

        return inedibleMenus;
    }

    private Coaches createCoach() {
        boolean isCreating = true;
        Coaches coaches = null;

        while (isCreating) {
            try {
                coaches = new Coaches(converter.convertToList(inputView.getCoaches()));
                isCreating = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return coaches;
    }

    private InedibleMenus createInedibleMenus(String coach) {
        boolean isCreating = true;
        InedibleMenus inedibleMenus = null;

        while (isCreating) {
            try {
                inedibleMenus = new InedibleMenus(converter.convertToList(inputView.getInedibleMenu(coach)));
                isCreating = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return inedibleMenus;
    }


}

