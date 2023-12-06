package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        checkDuplication(station);
        stations.add(station);
    }

    public static void deleteStation(String name) {
        stations.remove(checkExistence(name));
    }


    private static void checkDuplication(Station station) {
        for (Station stationOne : stations) {
            if (stationOne.getName().equals(station.getName())) {
                throw new IllegalArgumentException("[ERROR] 중복된 역 이름입니다.");
            }
        }
    }

    public static Station checkExistence(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
    }

}
