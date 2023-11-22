package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
