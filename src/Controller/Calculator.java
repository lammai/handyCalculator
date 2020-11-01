package Controller;

import Model.Number;

import java.math.BigDecimal;

public abstract class Calculator<T extends Number<T>> implements Convertible{

    public static final String HEX_VALUES = "0123456789ABCDEF";
    private T num;

    public Calculator(T num) {
        this.num = num;
    }

    public T getNum() {
        return this.num;
    }

    public abstract void add(T oNum);
    public abstract void subtract(T oNum);
    public abstract void multiply(T oNum);
    public abstract String[] divide(T oNum);

    public String convertTo(int base) {
        long originalDec;
        try {
            originalDec = Long.parseLong(new BigDecimal(this.getNum().getValue()).toPlainString());
        } catch (NumberFormatException e) {
            System.err.println("Input " + this.getNum().getValue() +" is too big.");
            originalDec = 0;
        }
        long dec = originalDec;
        if (dec == 0){
            return "0";
        }
        StringBuilder bin = new StringBuilder();
        while (dec != 0) {
            int index = (int) (Math.abs(dec) % base);
            bin.insert(0, HEX_VALUES.charAt(index));
            dec /= base;
        }
        if (originalDec < 0) {
            bin.insert(0, '-');
        }
        return bin.toString();
    }

    public String toDecimal() {
        double dec = 0.0;
        int currentPow = this.getNum().getValue().length()-1;
        for (int i = 0; i < this.getNum().getValue().length(); i++, currentPow--) {
            dec += Character.getNumericValue(this.getNum().getValue().charAt(i)) * Math.pow(this.getNum().getBase(), currentPow);
        }
        return ""+dec;
    }
}
