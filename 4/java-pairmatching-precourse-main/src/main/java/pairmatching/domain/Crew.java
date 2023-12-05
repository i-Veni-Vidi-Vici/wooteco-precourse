package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crew {
    private final List<String> beckendCrews;
    private final List<String> frontendCrews;

    public Crew() {
        beckendCrews = new ArrayList<>();
        frontendCrews = new ArrayList<>();

        initialize(beckendCrews, "backend");
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

}
