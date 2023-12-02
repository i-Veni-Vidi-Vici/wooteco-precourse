package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {

    private final List<String> coaches;
    public Coaches(List<String> coaches) {
        checkNameLength(coaches);
        checkCount(coaches);
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

    public List<String> get() {
        return Collections.unmodifiableList(coaches);
    }
}
