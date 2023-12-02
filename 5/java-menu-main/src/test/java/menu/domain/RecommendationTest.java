package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecommendationTest {

    @DisplayName("카테고리 선택")
    @Test
    void selectCategory(){
        Recommendation recommendation = new Recommendation();
        assertThat(recommendation.selectCategory()).isEqualTo(1);
    }
}
