package christmas.domain;

import static christmas.constants.Value.MAX_DATE;
import static christmas.constants.Value.MIN_DATE;

public class ReservedDate {

    private final Integer reservedDate;

    public ReservedDate(Integer reservedDate) {
        checkRange(reservedDate);
        this.reservedDate = reservedDate;
    }

    private void checkRange(Integer date) {
        if ((date < MIN_DATE.get()) || (date > MAX_DATE.get())) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getDate() {
        return reservedDate;
    }
}
