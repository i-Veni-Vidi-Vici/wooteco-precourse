package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoriesTest {

    @DisplayName("카테고리 추천, 크기는 5")
    @Test
    void recommend(){
        Categories categories = new Categories();
        assertThat(categories.recommend().size()).isEqualTo(5);
    }

    @DisplayName("카테고리 추천할 때, 중복되는 카테고리는 최대 2개")
    @Test
    void recommendByDuplicationCountMaxTwo(){
        Categories categories = new Categories();
        Map<String,Integer> categoryCount = new HashMap<>();

        List<String> recommendedCategories = categories.recommend();

        for (String recommendedCategory : recommendedCategories) {
            categoryCount.put(recommendedCategory, categoryCount.getOrDefault(recommendedCategory, 0)+1);
        }

        for (Integer value : categoryCount.values()) {
            assertThat(value).isLessThan(3);
        }
    }
}
