package Model;

/**
 * This class defines a representation of
 * a Binary number
 */
public class Hex extends Number {

    private static final int base = 16;

    /**
     * The default constructor set value to null.
     */
    public Hex() {super(null, base);}

    /**
     * This full constructor set the value and base of
     * a number.
     * @param aValue The String value to be set as the number's value.
     */
    public Hex(String aValue) {
        super(aValue, base);
    }
}
