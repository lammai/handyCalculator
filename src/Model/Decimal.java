package Model;

public class Decimal extends Number<Decimal> {

    private static final int base = 10;

    public Decimal(String aValue) {
        super(aValue, base);
    }
}
