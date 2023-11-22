package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("당첨 통계 계산")
    @Test
    void calculateWinnings(){
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(lottoResult.calculateWinnings(lottos)).isEqualTo(Map.of("1등",1,"2등",1));
    }

}
