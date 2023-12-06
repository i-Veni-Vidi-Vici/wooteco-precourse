package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SectionRepository {
    private static Map<Line, List<Station>> sections;


    public static void initialize(Line line, Station upstreamStation, Station downstreamStation){
        sections = new LinkedHashMap<>();
        sections.put(line, Arrays.asList(upstreamStation, downstreamStation));
    }

    public static void add(Line line, Station station, Integer Sequence){
        sections.get(line).add(Sequence, station);
    }

    public boolean checkStation(String name){
        for (Line line : sections.keySet()) {
            for (Station station : sections.get(line)) {
                return station.getName().equals(name);
            }
        }

        return false;
    }

    public Map<Line, List<Station>> get() {
        return Collections.unmodifiableMap(sections);
    }
}
