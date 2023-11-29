package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Cryptography {

    public String decode(String cryptogram) {
        List<String> splitValues = new ArrayList<>(List.of(cryptogram.split("")));
        int index = 0;

        while (index != splitValues.size()) {
            index = removeDuplication(splitValues);
        }

        return String.join("", splitValues);
    }

    private Integer removeDuplication(List<String> splitValues){
        int index = 0;
        String beforeValue = "initialValue";

        for (index = 0; index < splitValues.size(); index++) {
            if (beforeValue.equals(splitValues.get(index))) {
                splitValues.remove(index);
                splitValues.remove(index - 1);
                return 0;
            }

            beforeValue = splitValues.get(index);
        }

        return index;
    }
}
