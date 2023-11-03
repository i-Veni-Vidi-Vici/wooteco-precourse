package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        while (isRunning) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = computer.getInput();

                computer.checkNumber(userInput);
                computer.checkZero(userInput);

                Integer bonusNumber = Integer.parseInt(userInput);
                computer.checkRange(bonusNumber);
                computer.isIncluding(winningNumbers, bonusNumber);

                winningNumbers.add(Integer.parseInt(userInput));

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // 7. 당첨 내역 계산 로직




    }
}
