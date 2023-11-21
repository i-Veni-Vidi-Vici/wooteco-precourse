package racingcar;

import static racingcar.constants.Value.INITIAL_ZERO;

import racingcar.domain.Car;
import racingcar.domain.Judge;
import racingcar.domain.Round;
import racingcar.utility.Converter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public RacingManager() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    public void run() {
        Car car = new Car(converter.convertToMap(inputView.getCarName()));
        Round round = new Round(converter.convertToNumber(inputView.getRoundCount()));

        race(car, round);

        selectWinner(car);
    }

    private void race(Car car, Round round) {
        outputView.printRun();

        for (int roundCount = INITIAL_ZERO.get(); roundCount < round.getRoundCount(); roundCount++) {
            car.move();
            outputView.printResult(car.get());
        }
    }

    private void selectWinner(Car car) {
        Judge judge = new Judge();
        outputView.printWinner(judge.selectWinner(car.get()));
    }
}
