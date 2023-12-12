package pairmatching.domain;

import static pairmatching.constants.Value.FIRST_INDEX;
import static pairmatching.constants.Value.SECOND_INDEX;
import static pairmatching.constants.Value.THIRD_INDEX;

import java.util.List;
import pairmatching.constants.Course;
import pairmatching.constants.Level;
import pairmatching.utility.Converter;

public class Information {
    private final String information;

    public Information(String information) {
        Converter converter = new Converter();
        List<String> threeInformation = converter.convertToList(information);
        Course.checkExistence(threeInformation.get(FIRST_INDEX.get()));
        Level.checkLevelExistence(threeInformation.get(SECOND_INDEX.get()));
        Level.checkMissionExistence(threeInformation.get(THIRD_INDEX.get()));
        this.information = information;
    }

    public String get() {
        return information;
    }
}
