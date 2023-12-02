package menu.domain;

import static menu.constants.Category.ASIAN_FOOD;
import static menu.constants.Category.CHINESE_FOOD;
import static menu.constants.Category.JAPANESE_FOOD;
import static menu.constants.Category.KOREAN_FOOD;
import static menu.constants.Category.WESTERN_FOOD;

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

        while (recommendedCategories.size() != 5) {
            String category = categories.get(Randoms.pickNumberInRange(1, 5)-1);

            if (count(recommendedCategories, category) < 2) {
                recommendedCategories.add(category);
            }
        }

        return recommendedCategories;
    }

    private Integer count(List<String> recommendedCategories, String category) {
        Integer count = 0;

        for (String recommendedCategory : recommendedCategories) {
            if (recommendedCategory.equals(category)) {
                count++;
            }
        }

        return count;
    }
}
