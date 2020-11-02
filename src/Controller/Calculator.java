package Controller;

import Model.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

        BigDecimal ogDec = new BigDecimal(this.getNum().getValue());
        if (ogDec.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        StringBuilder bin = new StringBuilder();
        while (ogDec.compareTo(BigDecimal.ZERO) != 0) {
            int index = ogDec.abs().remainder(new BigDecimal(base+"")).intValueExact();
            bin.insert(0, HEX_VALUES.charAt(index));
            ogDec = ogDec.divide(new BigDecimal(base+""), RoundingMode.FLOOR);
        }
        if (new BigDecimal(this.getNum().getValue()).compareTo(BigDecimal.ZERO) < 0) {
            bin.insert(0, '-');
        }
        return bin.toString();
    }

    public String toDecimal() {
        String val = this.getNum().getValue();
        String negative = "";
        if (this.getNum().getValue().charAt(0) == '-') {
            val = this.getNum().getValue().substring(1);
            negative = "-";
        }

        double dec = 0.0;
        int currentPow = val.length()-1;
        for (int i = 0; i < val.length(); i++, currentPow--) {
            dec += Character.getNumericValue(val.charAt(i)) * Math.pow(this.getNum().getBase(), currentPow);
        }

        return negative+dec;
    }
}
