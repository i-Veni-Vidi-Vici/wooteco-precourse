package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Judge {
    public List<String> selectWinner(Map<String, String> car) {
        Integer maxDistance = calculateMaxDistance(car);
        List<String> winners = new ArrayList<>();

        for (String carName : car.keySet()) {
            if (maxDistance == car.get(carName).length()) {
                winners.add(carName);
            }
        }

        return winners;
    }

    private Integer calculateMaxDistance(Map<String, String> car) {
        Integer maxDistance = 0;

        for (String carName : car.keySet()) {
            if (maxDistance < car.get(carName).length()) {
                maxDistance = car.get(carName).length();
            }
        }

        return maxDistance;
    }
}
