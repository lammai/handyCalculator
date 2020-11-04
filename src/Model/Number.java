package Model;

/**
 * This class defines a Number object.
 * It handle initializing the inner representation value of a number and
 * provide methods that are common in all types of numbers.
 */
public abstract class Number {
    private String value;
    private final int base;

    /**
     * This constructor set the number's value and base using the
     * parameters.
     * @param aValue The value to be set as the value of a number.
     * @param aBase The base of this number system.
     */
    public Number(String aValue, int aBase) {
        this.value = aValue;
        this.base = aBase;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value='" + value + '\'' +
                ", base=" + base +
                '}';
    }

    /**
     * This method provide the String representation of the number.
     * @return a String value of the number.
     */
    public String getValue() {
        return value;
    }

    /**
     * This method use the parameter String and set it as the number's value.
     * @param value The String to be set as the value of the number.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Provide the number system's base of the number.
     * @return an integer value of the number's base.
     */
    public int getBase() {
        return base;
    }
}
