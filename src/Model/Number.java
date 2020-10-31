package Model;

public abstract class Number<T extends Number<?>> {
    private String value;
    private final int base;

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

    public boolean equals(T oNum) {
        return this.getValue().equals(oNum.getValue());
    }

    public int compareTo(T oNum) {
        return this.getValue().compareTo(oNum.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getBase() {
        return base;
    }
}
