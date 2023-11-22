package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoResultTest {

    @DisplayName("당첨 통계 계산, 1등 2개 + 2등 1개")
    @Test
    void calculate() {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.FIRST)).isEqualTo(2);
        assertThat(lottoResult.get().get(Prize.SECOND)).isEqualTo(1);
    }

    @DisplayName("당첨 통계 계산, 1등")
    @Test
    void calculateByFirst() {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.FIRST)).isEqualTo(1);

        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == Prize.FIRST) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 2등")
    @Test
    void calculateBySecond() {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        Integer bonusNumber = 6;

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.SECOND)).isEqualTo(1);

        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == Prize.SECOND) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 3등")
    @Test
    void calculateByThird() {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        Integer bonusNumber = 8;

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.THIRD)).isEqualTo(1);

        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == Prize.THIRD) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 4등 (보너스 일치, 불일치)")
    @ParameterizedTest
    @ValueSource(ints = {6, 9})
    void calculateByFourth(Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 8);

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.FOURTH)).isEqualTo(1);

        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == Prize.FOURTH) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 5등 (보너스 일치, 불일치)")
    @ParameterizedTest
    @ValueSource(ints = {6, 10})
    void calculateByFifth(Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 3, 7, 8, 9);

        lottoResult.calculate(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.get().get(Prize.FIFTH)).isEqualTo(1);

        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == Prize.FIFTH) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 당첨x")
    @ParameterizedTest
    @ValueSource(ints = {3, 11})
    void calculateByNothing(Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningLotto = List.of(1, 2, 7, 8, 9, 10);

        lottoResult.calculate(lottos, winningLotto, bonusNumber);

        for (Prize prize : lottoResult.get().keySet()) {
            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

}
