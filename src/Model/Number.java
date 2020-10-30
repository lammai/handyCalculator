package Model;

public abstract class Number<T extends Number> {
    private String value;
    private int base;

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

    public abstract boolean equals(T oNum);

    public abstract int compareTo(T oNum);

    public String getValue() {
        return value;
    }

    public int getBase() {
        return base;
    }
}
