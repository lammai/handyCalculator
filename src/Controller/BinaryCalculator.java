package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

/**
 * This class provides the functionalities of a calculator that can handle
 * basic Binary calculations as well as conversions.
 */
public class BinaryCalculator extends Calculator<Binary> {

    /**
     * The constructor set the Binary object
     * to perform calculation/conversion on.
     * @param num The Binary object.
     */
    public BinaryCalculator(Binary num) { super(num); }

    @Override
    public void add(Binary oNum) {
        Decimal bin = this.toDecimal();
        new DecimalCalculator(bin).add(new BinaryCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(bin).toBinary().getValue());
    }

    @Override
    public void subtract(Binary oNum) {
        Decimal bin = this.toDecimal();
        new DecimalCalculator(bin).subtract(new BinaryCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(bin).toBinary().getValue());
    }

    @Override
    public void multiply(Binary oNum) {
        Decimal bin = this.toDecimal();
        new DecimalCalculator(bin).multiply(new BinaryCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(bin).toBinary().getValue());
    }

    @Override
    public String[] divide(Binary oNum) {
        Decimal bin = this.toDecimal();
        String[] remainder = new String[2];             // Remainder[0] = Decimal remainder     Remainder[1] = Binary remainder
        remainder[0] = new DecimalCalculator(bin).divide(new BinaryCalculator(oNum).toDecimal())[0];
        remainder[1] = new DecimalCalculator(new Decimal(remainder[0])).toBinary().getValue();
        this.getNum().setValue(new DecimalCalculator(bin).toBinary().getValue());
        return remainder;
    }

    @Override
    public Decimal toDecimal() {
        return new Decimal(convertToDecimal());
    }

    @Override
    public Binary toBinary() {
        return this.getNum();
    }

    @Override
    public Hex toHex() {
        Decimal dec = this.toDecimal();
        DecimalCalculator decCalc = new DecimalCalculator(dec);
        return decCalc.toHex();
    }
}
