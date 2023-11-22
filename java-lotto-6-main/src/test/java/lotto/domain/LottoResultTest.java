package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoResultTest {

    private List<Lotto> lottos;

    @BeforeEach
    void beforeEach() {
        lottos = new ArrayList<>();
    }

    private void compareResult(LottoResult lottoResult, Prize winningPrize) {
        for (Prize prize : lottoResult.get().keySet()) {
            if (prize == winningPrize) {
                continue;
            }

            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 계산, 1등 2개 + 2등 1개")
    @Test
    void calculate() {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.FIRST)).isEqualTo(2);
        assertThat(lottoResult.get().get(Prize.SECOND)).isEqualTo(1);
    }


    @DisplayName("당첨 통계 계산, 1등")
    @Test
    void calculateByFirst() {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.FIRST)).isEqualTo(1);
        compareResult(lottoResult, Prize.FIRST);
    }

    @DisplayName("당첨 통계 계산, 2등")
    @Test
    void calculateBySecond() {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        Integer bonusNumber = 6;
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.SECOND)).isEqualTo(1);
        compareResult(lottoResult, Prize.SECOND);
    }

    @DisplayName("당첨 통계 계산, 3등")
    @Test
    void calculateByThird() {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        Integer bonusNumber = 8;
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.THIRD)).isEqualTo(1);
        compareResult(lottoResult, Prize.THIRD);
    }

    @DisplayName("당첨 통계 계산, 4등 (보너스 일치, 불일치)")
    @ParameterizedTest
    @ValueSource(ints = {6, 9})
    void calculateByFourth(Integer bonusNumber) {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 8);
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.FOURTH)).isEqualTo(1);
        compareResult(lottoResult, Prize.FOURTH);
    }

    @DisplayName("당첨 통계 계산, 5등 (보너스 일치, 불일치)")
    @ParameterizedTest
    @ValueSource(ints = {6, 10})
    void calculateByFifth(Integer bonusNumber) {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 3, 7, 8, 9);
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        assertThat(lottoResult.get().get(Prize.FIFTH)).isEqualTo(1);
        compareResult(lottoResult, Prize.FIFTH);
    }

    @DisplayName("당첨 통계 계산, 당첨x")
    @ParameterizedTest
    @ValueSource(ints = {3, 11})
    void calculateByNothing(Integer bonusNumber) {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningLotto = List.of(1, 2, 7, 8, 9, 10);
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), bonusNumber));
        // then
        for (Prize prize : lottoResult.get().keySet()) {
            assertThat(lottoResult.get().get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningsRate() {
        // given
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 5등
        lottos.add(new Lotto(List.of(1, 2, 11, 12, 13, 14))); // 당첨x
        List<Integer> winningLotto = List.of(1, 2, 3, 7, 8, 9);
        // when
        LottoResult lottoResult = new LottoResult(lottos, new WinningLotto(new Lotto(winningLotto), 10));
        // then
        assertThat(lottoResult.calculateEarningsRate()).isEqualTo(250.0);
    }
}
