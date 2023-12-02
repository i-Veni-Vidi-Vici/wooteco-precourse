package menu.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Coaches {
    private final List<String> coaches;

    public Coaches(List<String> coaches) {
        checkNameLength(coaches);
        checkCount(coaches);
        checkDuplication(coaches);
        checkBlank(coaches);
        checkWhitespace(coaches);
        this.coaches = coaches;
    }

    private void checkNameLength(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치 이름 길이는 2~4자 이어야 입니다.");
            }
        }
    }

    private void checkCount(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 2~5명 이어야 합니다.");
        }
    }

    private void checkDuplication(List<String> coaches) {
        if (new HashSet<>(coaches).size() != coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름이 중복 됩니다.");
        }
    }

    private void checkBlank(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 코치 이름이 공백으로 이루어져 있습니다.");
            }
        }
    }

    private void checkWhitespace(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.trim().length() != coach.length()) {
                throw new IllegalArgumentException("[ERROR] 코치 이름 앞 또는 뒤에 공백이 포함 됩니다.");
            }
        }
    }

    public List<String> get() {
        return Collections.unmodifiableList(coaches);
    }
}
