package Model;

/**
 * This class defines a representation of
 * a Binary number
 */
public class Binary extends Number{

    private static final int base = 2;

    /**
     * This full constructor set the value and base of
     * a number.
     * @param aValue The String value to be set as the number's value.
     */
    public Binary(String aValue) {
        super(aValue, base);
    }
}
