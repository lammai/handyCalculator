package Model;

/**
 * This class defines a representation of a unit.
 * A unit is a decimal number with some type of unit.
 * @param <E> a type of enumeration object.
 */
public abstract class Unit<E extends Enum<E>> extends Decimal {

    private E unit;

    /**
     * Full constructor set the
     * @param value the decimal value.
     * @param unit the unit of this value.
     */
    public Unit(String value, E unit) {
        super(value);
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "value=" + this.getValue() + ", unit='" + unit + '\'';
    }

    /**
     * Provide the unit of this data.
     * @return an enum of the unit.
     */
    public E getUnit() {
        return unit;
    }

    /**
     * Allows the user to set a new unit.
     * @param e The new unit to be set to this value's unit.
     */
    public void setUnit(E e) {
        this.unit = e;
    }
}
