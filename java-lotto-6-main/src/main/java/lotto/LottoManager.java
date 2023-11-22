package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.utility.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public LottoManager() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        outputView.printLotto(lottos);
        WinningLotto winningLotto = createWinningLotto(createWinningNumber());

        printResult(lottos, winningLotto);
    }

    private List<Lotto> purchaseLotto() {
        boolean isPurchasing = true;
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = new ArrayList<>();

        while (isPurchasing) {
            try {
                lottos = lottoMachine.generate(converter.convertToNumber(inputView.getMoney()));
                isPurchasing = false;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return lottos;
    }

    private Lotto createWinningNumber() {
        boolean isCreating = true;
        Lotto lotto = null;

        while (isCreating) {
            try {
                lotto = new Lotto(converter.convertToList(inputView.getWinningNumber()));
                isCreating = false;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return lotto;
    }

    private WinningLotto createWinningLotto(Lotto lotto) {
        boolean isCreating = true;
        WinningLotto winningLotto = null;

        while (isCreating) {
            try {
                winningLotto = new WinningLotto(lotto, converter.convertToNumber(inputView.getBonusNumber()));
                isCreating = false;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return winningLotto;
    }

    private void printResult(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        outputView.printResult(lottoResult.get());
        outputView.printEarningsRate(lottoResult.calculateEarningsRate());
    }

}
