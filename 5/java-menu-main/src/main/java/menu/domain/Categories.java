package menu.domain;

import static menu.constants.Category.ASIAN_FOOD;
import static menu.constants.Category.CHINESE_FOOD;
import static menu.constants.Category.JAPANESE_FOOD;
import static menu.constants.Category.KOREAN_FOOD;
import static menu.constants.Category.WESTERN_FOOD;
import static menu.constants.CategoryValue.CATEGORY_COUNT;
import static menu.constants.Value.INITIAL_ZERO;
import static menu.constants.CategoryValue.MAX_CATEGORY_NUMBER;
import static menu.constants.CategoryValue.MAX_DUPLICATION_COUNT;
import static menu.constants.CategoryValue.MIN_CATEGORY_NUMBER;
import static menu.constants.Value.ONE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Categories {
    private final List<String> categories;

    public Categories() {
        categories = List.of(JAPANESE_FOOD.get(), KOREAN_FOOD.get(), CHINESE_FOOD.get(), ASIAN_FOOD.get(),
                WESTERN_FOOD.get());
    }

    public List<String> recommend() {
        List<String> recommendedCategories = new ArrayList<>();

        while (recommendedCategories.size() != CATEGORY_COUNT.get()) {
            String category = categories.get(Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER.get(),
                    MAX_CATEGORY_NUMBER.get())-ONE.get());

            if (count(recommendedCategories, category) < MAX_DUPLICATION_COUNT.get()) {
                recommendedCategories.add(category);
            }
        }

        return recommendedCategories;
    }

    private Integer count(List<String> recommendedCategories, String category) {
        Integer count = INITIAL_ZERO.get();

        for (String recommendedCategory : recommendedCategories) {
            if (recommendedCategory.equals(category)) {
                count++;
            }
        }

        return count;
    }
}
