package pairmatching.domain;

import static pairmatching.constants.Course.BACKEND;
import static pairmatching.constants.Course.FRONTEND;
import static pairmatching.constants.Error.FILE_ERROR;
import static pairmatching.constants.Message.ABSOLUTE_ROUTE;
import static pairmatching.constants.Message.BACKEND_FILE_NAME;
import static pairmatching.constants.Message.FILE_NAME;
import static pairmatching.constants.Message.FRONTEND_FILE_NAME;
import static pairmatching.constants.Symbol.WHITESPACE;
import static pairmatching.constants.Value.FIRST_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pairmatching.utility.Converter;

public class Crew {
    private final List<String> backendCrews;
    private final List<String> frontendCrews;
    private final Map<String, List<String>> pairCrews;

    public Crew() {
        pairCrews = new LinkedHashMap<>();
        backendCrews = new ArrayList<>();
        frontendCrews = new ArrayList<>();

        initialize(backendCrews, BACKEND_FILE_NAME.getMessage());
        initialize(frontendCrews, FRONTEND_FILE_NAME.getMessage());
    }

    private void initialize(List<String> crews, String type) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(
                    ABSOLUTE_ROUTE.getMessage() + type + FILE_NAME.getMessage()));
            String line;
            while ((line = input.readLine()) != null) {
                crews.addAll(Arrays.asList(line.split(WHITESPACE.get())));
            }
        } catch (IOException e) {
            System.out.println(FILE_ERROR.getMessage());
        }
    }

    public List<String> match(String information) {
        List<String> crews = new ArrayList<>();
        Converter converter = new Converter();
        List<String> threeInformation = converter.convertToList(information);

        if (threeInformation.get(FIRST_INDEX.get()).equals(BACKEND.getName())) {
            crews = Randoms.shuffle(backendCrews);
        }
        if (threeInformation.get(FIRST_INDEX.get()).equals(FRONTEND.getName())) {
            crews = Randoms.shuffle(frontendCrews);
        }

        pairCrews.put(information, crews);
        return crews;
    }

    public boolean checkMatching(String information) {
        return pairCrews.containsKey(information);
    }

    public List<String> search(String information) {
        return pairCrews.get(information);
    }

    public void initialize() {
        pairCrews.clear();
    }
}
