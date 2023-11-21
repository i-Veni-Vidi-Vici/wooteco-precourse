package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRun() {
        System.out.println("실행 결과");
    }
    public void printResult(Map<String, String> car) {
        for (String carName : car.keySet()) {
            System.out.println(carName + " : " + car.get(carName));
        }
    }


    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        boolean isMany = false;

        for (String winner : winners) {
            if(isMany){
                System.out.print(", ");
            }

            System.out.print(winner);
            isMany = true;
        }
    }
}
