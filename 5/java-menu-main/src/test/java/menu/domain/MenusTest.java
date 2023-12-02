package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenusTest {

    @DisplayName("메뉴 추천, 크기는 5")
    @Test
    void recommend(){
        Menus menus = new Menus();
        assertThat(menus.recommend().size()).isEqualTo(5);
    }
}
