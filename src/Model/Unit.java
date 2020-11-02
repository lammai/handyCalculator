package Model;

public abstract class Unit<E extends Enum<E>> extends Decimal {

    private final Enum<E> unit;

    public Unit(String value, Enum<E> unit) {
        super(value);
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "value=" + this.getValue() + ", unit='" + unit + '\'';
    }

    public Enum<E> getUnit() {
        return unit;
    }
}
