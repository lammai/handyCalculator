package Model;

public class Decimal extends Number<Decimal> {

    private static final int base = 10;

    public Decimal(String aValue) {
        super(aValue, base);
    }

    @Override
    public boolean equals(Decimal oNum) {
        return this.getValue().equals(oNum.getValue());
    }

    @Override
    public int compareTo(Decimal oNum) {
        return this.getValue().compareTo(oNum.getValue());
    }
}
