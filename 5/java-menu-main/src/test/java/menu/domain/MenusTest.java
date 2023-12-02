package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenusTest {

    @DisplayName("메뉴 추천, 크기는 5")
    @Test
    void recommend() {
        Menus menus = new Menus();
        Categories categories = new Categories();
        assertThat(menus.recommend(categories.recommend(), List.of()).size()).isEqualTo(5);
    }

    @DisplayName("메뉴 추천, 중복x")
    @Test
    void recommendByNotDuplication() {
        Menus menus = new Menus();

        List<String> recommendedMenus = menus.recommend(List.of("일식", "일식", "한식", "한식", "중식"), List.of());

        assertThat(new HashSet<>(recommendedMenus).size()).isEqualTo(5);
    }

    @DisplayName("메뉴 추천, 못 먹는 메뉴 포함x")
    @Test
    void recommendByNotInedibleMenus() {
        Menus menus = new Menus();

        List<String> recommendedMenus = menus.recommend(List.of("일식", "일식", "일식", "일식", "일식"),
                List.of("규동", "우동", "미소시루", "스시"));
        assertThat(new HashSet<>(recommendedMenus)).isEqualTo(Set.of("가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    }
}
