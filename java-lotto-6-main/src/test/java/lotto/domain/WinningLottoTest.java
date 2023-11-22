package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 로또 생성")
    @Test
    void create(){
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);
        assertThat(winningLotto.getWinningNumber().getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복될 때, 예외 처리")
    @Test
    void createByDuplication(){
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
