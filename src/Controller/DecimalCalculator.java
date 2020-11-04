package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class provides the functionalities of a calculator that can handle
 * basic Decimal calculations as well as conversions.
 */
public class DecimalCalculator extends Calculator<Decimal> {

    /**
     * The constructor set the Decimal object
     * to perform calculation/conversion on.
     * @param num The Decimal object.
     */
    public DecimalCalculator(Decimal num) {
        super(num);
    }

    @Override
    public void add(Decimal oNum) {
        BigDecimal result = new BigDecimal(this.getNum().getValue()).add(new BigDecimal(oNum.getValue()));
        this.getNum().setValue(result.toPlainString());
    }

    @Override
    public void subtract(Decimal oNum) {
        BigDecimal result = new BigDecimal(this.getNum().getValue()).subtract(new BigDecimal(oNum.getValue()));
        this.getNum().setValue(result.toPlainString());
    }

    @Override
    public void multiply(Decimal oNum) {
        BigDecimal result = new BigDecimal(this.getNum().getValue()).multiply(new BigDecimal(oNum.getValue()));
        this.getNum().setValue(result.toPlainString());
    }

    @Override
    public String[] divide(Decimal oNum) {
        BigDecimal result = new BigDecimal(this.getNum().getValue()).divide(new BigDecimal(oNum.getValue()), RoundingMode.FLOOR);
        BigDecimal remainder = new BigDecimal(this.getNum().getValue()).remainder(new BigDecimal(oNum.getValue()));
        this.getNum().setValue(result.toPlainString());
        return new String[]{ remainder.toPlainString() };
    }

    @Override
    public Decimal convertToDec() {
        return this.getNum();
    }

    @Override
    public Binary convertToBin() {
        return new Binary(convertTo(2));
    }

    @Override
    public Hex convertToHex() {
        return new Hex(convertTo(16));
    }
}
