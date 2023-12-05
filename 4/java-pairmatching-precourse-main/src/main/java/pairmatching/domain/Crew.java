package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Crew {
    private final List<String> backendCrews;
    private final List<String> frontendCrews;

    private final Map<String, List<String>> pairCrews;

    public Crew() {
        pairCrews = new LinkedHashMap<>();
        backendCrews = new ArrayList<>();
        frontendCrews = new ArrayList<>();

        initialize(backendCrews, "backend");
        initialize(frontendCrews, "frontend");
    }

    private void initialize(List<String> crews, String type) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(
                    "C:\\i_Veni_Vidi_Vici\\precourse-test\\4\\java-pairmatching-precourse-main\\"
                            + "src\\main\\resources\\" + type + "-crew.md"));
            String line;
            while ((line = input.readLine()) != null) {
                crews.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            System.out.println("[ERROR] 파일이 없습니다.");
        }
    }

    public List<String> match(String type) {
        List<String> crews = new ArrayList<>();
        List<String> types = Arrays.asList(type.split(","));

        if (types.get(0).equals("백엔드")) {
            crews = Randoms.shuffle(backendCrews);
        }
        if (types.get(0).equals("프론트엔드")) {
            crews = Randoms.shuffle(frontendCrews);
        }

        pairCrews.put(type, crews);
        return crews;
    }

    public boolean checkMatching(String type) {
        return pairCrews.containsKey(type);
    }

    public List<String> search(String type) {
        return pairCrews.get(type);
    }

}
