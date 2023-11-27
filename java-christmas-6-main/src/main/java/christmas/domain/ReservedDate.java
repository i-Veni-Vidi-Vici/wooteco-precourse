package christmas.domain;

public class ReservedDate {

    private final Integer reservedDate;

    public ReservedDate(Integer reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Integer get() {
        return reservedDate;
    }
}
