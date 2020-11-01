package Model;

public class Binary extends Number<Binary> {

    private static final int base = 2;

    public Binary() {super();}

    public Binary(String aValue) {
        super(aValue, base);
    }
}
