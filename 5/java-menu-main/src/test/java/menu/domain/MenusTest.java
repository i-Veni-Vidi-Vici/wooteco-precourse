package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenusTest {

    @DisplayName("메뉴 추천, 크기는 5")
    @Test
    void recommend() {
        Menus menus = new Menus();
        Categories categories = new Categories();
        assertThat(menus.recommend(categories.recommend(),
                Map.of("포비", new InedibleMenus(List.of()))).get("포비").size()).isEqualTo(5);
    }

    @DisplayName("메뉴 추천, 중복x")
    @Test
    void recommendByNotDuplication() {
        Menus menus = new Menus();

        Map<String, List<String>> recommendedMenus = menus.recommend(List.of("일식", "일식", "한식", "한식", "중식"),
                Map.of("포비", new InedibleMenus(List.of())));

        assertThat(new HashSet<>(recommendedMenus.get("포비")).size()).isEqualTo(5);
    }

    @DisplayName("메뉴 추천, 못 먹는 메뉴 포함x")
    @Test
    void recommendByNotInedibleMenus() {
        Menus menus = new Menus();

        Map<String, List<String>> recommendedMenus = menus.recommend(
                List.of("일식", "일식", "일식", "일식", "일식", "일식", "일식"),
                Map.of("포비", new InedibleMenus(List.of("규동", "우동"))));

        assertThat(new HashSet<>(recommendedMenus.get("포비"))).isEqualTo(
                Set.of("미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    }
}
