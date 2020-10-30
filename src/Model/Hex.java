package Model;

public class Hex extends Number<Hex> {

    private static final int base = 16;

    public Hex(String aValue) {
        super(aValue, base);
    }

    @Override
    public boolean equals(Hex oNum) {
        return this.getValue().equals(oNum.getValue());
    }

    @Override
    public int compareTo(Hex oNum) {
        return this.getValue().compareTo(oNum.getValue());
    }
}
