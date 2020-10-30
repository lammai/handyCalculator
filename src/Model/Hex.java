package Model;

public class Hex extends Number<Hex> {

    private static final int base = 16;

    public Hex(String aValue) {
        super(aValue, base);
    }
}
