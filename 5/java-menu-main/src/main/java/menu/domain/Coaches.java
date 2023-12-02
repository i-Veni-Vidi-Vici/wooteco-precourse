package menu.domain;

import static menu.constants.CoachValue.MAX_COACH_COUNT;
import static menu.constants.CoachValue.MAX_NAME_LENGTH;
import static menu.constants.CoachValue.MIN_COACH_COUNT;
import static menu.constants.CoachValue.MIN_NAME_LENGTH;
import static menu.constants.Error.BLANK_ERROR;
import static menu.constants.Error.COACH_COUNT_ERROR;
import static menu.constants.Error.COACH_DUPLICATION_ERROR;
import static menu.constants.Error.COACH_LENGTH_ERROR;
import static menu.constants.Error.WHITESPACE_ERROR;

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
            if ((coach.length() < MIN_NAME_LENGTH.get()) || (coach.length() > MAX_NAME_LENGTH.get())) {
                throw new IllegalArgumentException(COACH_LENGTH_ERROR.getMessage());
            }
        }
    }

    private void checkCount(List<String> coaches) {
        if ((coaches.size() < MIN_COACH_COUNT.get()) || (coaches.size() > MAX_COACH_COUNT.get())) {
            throw new IllegalArgumentException(COACH_COUNT_ERROR.getMessage());
        }
    }

    private void checkDuplication(List<String> coaches) {
        if ((new HashSet<>(coaches).size()) != coaches.size()) {
            throw new IllegalArgumentException(COACH_DUPLICATION_ERROR.getMessage());
        }
    }

    private void checkBlank(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.isBlank()) {
                throw new IllegalArgumentException(BLANK_ERROR.getMessage());
            }
        }
    }

    private void checkWhitespace(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.trim().length() != coach.length()) {
                throw new IllegalArgumentException(WHITESPACE_ERROR.getMessage());
            }
        }
    }

    public List<String> get() {
        return Collections.unmodifiableList(coaches);
    }
}
