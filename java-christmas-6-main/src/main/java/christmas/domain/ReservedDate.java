package christmas.domain;

public class ReservedDate {

    private final Integer reservedDate;

    public ReservedDate(Integer reservedDate) {
        checkRange(reservedDate);
        this.reservedDate = reservedDate;
    }

    private void checkRange(Integer reservedDate) {
        if ((reservedDate < 1) || (reservedDate > 31)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer get() {
        return reservedDate;
    }
}
