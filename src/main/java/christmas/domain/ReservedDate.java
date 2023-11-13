package christmas.domain;

public class ReservedDate {

    private final Integer reservedDate;

    public ReservedDate(Integer reservedDate) {
        checkRange(reservedDate);
        this.reservedDate = reservedDate;
    }

    private void checkRange(Integer date) {
        if ((date < 1) || (date > 31)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getDate() {
        return reservedDate;
    }
}
