package Model;

public class RateUnit extends Unit<RateUnit.Rate> {

    public enum Rate {
        BIT_PER_SECOND,
        KILOBIT_PER_SECOND,
        MEGABIT_PER_SECOND,
        GIGABIT_PER_SECOND,
        TERABIT_PER_SECOND
    }

    public RateUnit(String value, Rate unit) {
        super(value, unit);
    }
}
