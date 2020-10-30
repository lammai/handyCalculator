package Model;

public class Binary extends Number<Binary> {

    private static final int base = 2;

    public Binary(String aValue) {
        super(aValue, base);
    }

    @Override
    public boolean equals(Binary oNum) {
        return this.getValue().equals(oNum.getValue());
    }

    @Override
    public int compareTo(Binary oNum) {
        return this.getValue().compareTo(oNum.getValue());
    }
}
