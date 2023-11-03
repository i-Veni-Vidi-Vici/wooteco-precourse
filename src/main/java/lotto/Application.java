package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.User;
import lotto.ui.Computer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();

        User user = new User();
        Computer computer = new Computer();
        user.purchaseLotto();

        // 로또 개수 만큼 번호 계산
        for (int i = 0; i < user.lottoCount; i++) {
            lottos.add(computer.calculateLottoNumber());
        }

        // 4. 로또 번호 출력
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }

        // 5. 당첨 번호 입력
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isRunning = true;
        while (isRunning) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<String> userInputs = Arrays.asList(computer.getInput().split(","));

                computer.checkSize(userInputs);
                winningNumbers = new ArrayList<>();

                for (String userInput : userInputs) {
                    computer.checkNumber(userInput);
                    computer.checkZero(userInput);

                    Integer lottoNumber = Integer.parseInt(userInput);
                    computer.checkRange(lottoNumber);

                    winningNumbers.add(Integer.parseInt(userInput));
                }
                System.out.println(winningNumbers);
                computer.checkDuplication(winningNumbers);

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // 6. 보너스 번호 입력
        isRunning = true;
        Integer bonusNumber = null;
        while (isRunning) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = computer.getInput();

                computer.checkNumber(userInput);
                computer.checkZero(userInput);

                bonusNumber = Integer.parseInt(userInput);
                computer.checkRange(bonusNumber);
                computer.isIncluding(winningNumbers, bonusNumber);

                //winningNumbers.add(Integer.parseInt(userInput));

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // 7. 당첨 내역 계산 로직
        int count;
        List<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            count = 0;
            for (int i = 0; i < 6; i++) {
                if (lotto.getNumbers().contains(winningNumbers.get(i))) {
                    count++;
                }
            }
            if (count == 6) {
                lottoResult.set(0, lottoResult.get(0) + 1);
                continue;
            }
            if (count == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    lottoResult.set(1, lottoResult.get(1) + 1);
                    continue;
                }
                lottoResult.set(2, lottoResult.get(2) + 1);
                continue;
            }
            if (count == 4) {
                lottoResult.set(3, lottoResult.get(3) + 1);
                continue;
            }
            if (count == 3) {
                lottoResult.set(4, lottoResult.get(4) + 1);
            }
        }
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000));
        int sum = 0;
        String rateInvestment;

        // 8. 수익률 계산 로직
        for (int i = 0; i < lottoResult.size(); i++) {
            sum += lottoResult.get(i) * prizeMoney.get(i);
        }

        rateInvestment = String.format(".1f", (sum / 1000.0) * 100);

        // 9. 당첨 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+lottoResult.get(4)+"개");
        System.out.println("4개 일치 (50,000원) - "+lottoResult.get(3)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lottoResult.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lottoResult.get(1)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lottoResult.get(0)+"개");

    }
}
