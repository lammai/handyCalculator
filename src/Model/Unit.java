package Model;

public abstract class Unit<E extends Enum<E>> extends Decimal {

    private Enum<E> unit;

    public Unit(String value, Enum<E> unit) {
        super(value);
        this.unit = unit;
    }

    public boolean equals(Unit<E> oNum) {
        return this.getUnit().equals(oNum.getUnit()) && this.getValue().equals(oNum.getValue());
    }

    public int compareTo(Unit<E> oNum) {
        return this.getValue().compareTo(oNum.getValue());
    }

    @Override
    public String toString() {
        return "value=" + this.getValue() + ", unit='" + unit + '\'';
    }

    public Enum<E> getUnit() {
        return unit;
    }
}
