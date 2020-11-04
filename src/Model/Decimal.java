package Model;

/**
 * This class defines a representation
 * of a decimal number.
 */
public class Decimal extends Number {

    private static final int base = 10;

    /**
     * This full constructor set the value and base of
     * a number.
     * @param aValue The String value to be set as the number's value.
     */
    public Decimal(String aValue) {
        super(aValue, base);
    }
}
