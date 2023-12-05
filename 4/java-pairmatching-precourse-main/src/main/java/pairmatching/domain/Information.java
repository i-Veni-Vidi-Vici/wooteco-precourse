package pairmatching.domain;


import java.util.List;
import pairmatching.constants.Course;
import pairmatching.constants.Level;
import pairmatching.utility.Converter;

public class Information {
    private final String information;

    public Information(String information) {
        Converter converter = new Converter();
        List<String> threeInformation = converter.convertToList(information);
        Course.checkExistence(threeInformation.get(0));
        Level.checkLevelExistence(threeInformation.get(1));
        Level.checkMissionExistence(threeInformation.get(2));
        this.information = information;
    }

    public String get() {
        return information;
    }
}
