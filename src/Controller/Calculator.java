package Controller;

import Model.Number;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The Calculator abstract class provide the list of methods for
 * basic calculations. It also defines the logic of conversions.
 * @param <T> A type of Number
 */
public abstract class Calculator<T extends Number> implements Convertible{

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final T num;

    /**
     * This constructor setup the Number.
     * @param num The Number type to be set.
     */
    public Calculator(T num) {
        this.num = num;
    }

    /**
     * This method returns the type of Number when called.
     * @return A type of Number.
     */
    public T getNum() {
        return this.num;
    }

    /**
     * This method should add two Number of the same type,
     * modifying the implicit Number to store the result of addition.
     * @param oNum The explicit Number to be added.
     */
    public abstract void add(T oNum);

    /**
     * This method should subtract two Number of the same type,
     * modifying the implicit Number to store the result of subtraction.
     * @param oNum The explicit Number to be subtract.
     */
    public abstract void subtract(T oNum);

    /**
     * This method should multiply two Number of the same type,
     * modifying the implicit Number to store the result of multiplication.
     * @param oNum The explicit Number to be multiply.
     */
    public abstract void multiply(T oNum);

    /**
     * This method should divide two Number of the same type,
     * modifying the implicit Number to store the result of division.
     * The remainder of the division will be returned as a String array.
     * If this division is performed on Binary or Hex, the returned String array should
     * contains both Decimal remainder and Binary or Hex remainder, where Decimal remainder
     * is the first value in the array, Binary/Hex remainder will be the second value.
     * @param oNum The explicit Number to be subtract.
     * @return The remainder.
     */
    public abstract String[] divide(T oNum);

    /**
     * This method handle the conversion of Decimal to another type (Binary or Hex).
     * @param base The base of the number system that will be convert to.
     * @return The converted value in the form of a String.
     */
    public String convertTo(int base) {
        BigDecimal ogDec = new BigDecimal(this.getNum().getValue());
        if (ogDec.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        StringBuilder num = new StringBuilder();
        while (ogDec.compareTo(BigDecimal.ZERO) != 0) {
            int index = ogDec.abs().remainder(new BigDecimal(base+"")).intValue();
            num.insert(0, HEX_VALUES.charAt(index));
            ogDec = ogDec.abs().divide(new BigDecimal(base+""), RoundingMode.FLOOR);
        }
        if (new BigDecimal(this.getNum().getValue()).compareTo(BigDecimal.ZERO) < 0) {
            num.insert(0, '-');
        }
        return num.toString();
    }

    /**
     * This method handle the conversion of a Binary or Hex number to a Decimal.
     * @return The converted decimal value in the form of a String.
     */
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
        return negative + new BigDecimal(dec).toPlainString();
    }
}
