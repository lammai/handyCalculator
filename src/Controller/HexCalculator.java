package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

/**
 * This class provides the functionalities of a calculator that can handle
 * basic Hex calculations as well as conversions.
 */
public class HexCalculator extends Calculator<Hex> {

    /**
     * The constructor set the Hex object
     * to perform calculation/conversion on.
     * @param num The Hex object.
     */
    public HexCalculator(Hex num) {
        super(num);
    }

    @Override
    public void add(Hex oNum) {
        Decimal hex = this.toDecimal();
        new DecimalCalculator(hex).add(new HexCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(hex).toHex().getValue());
    }

    @Override
    public void subtract(Hex oNum) {
        Decimal hex = this.toDecimal();
        new DecimalCalculator(hex).subtract(new HexCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(hex).toHex().getValue());
    }

    @Override
    public void multiply(Hex oNum) {
        Decimal hex = this.toDecimal();
        new DecimalCalculator(hex).multiply(new HexCalculator(oNum).toDecimal());
        this.getNum().setValue(new DecimalCalculator(hex).toHex().getValue());
    }

    @Override
    public String[] divide(Hex oNum) {
        Decimal hex = this.toDecimal();
        String[] remainder = new String[2];     // Remainder[0] = Decimal remainder     Remainder[1] = Hex remainder
        remainder[0] = new DecimalCalculator(hex).divide(new HexCalculator(oNum).toDecimal())[0];
        remainder[1] = new DecimalCalculator(new Decimal(remainder[0])).toHex().getValue();
        this.getNum().setValue(new DecimalCalculator(hex).toHex().getValue());
        return remainder;
    }

    @Override
    public Decimal toDecimal() {
        return new Decimal(convertToDecimal());
    }

    @Override
    public Binary toBinary() {
        Decimal dec = this.toDecimal();
        DecimalCalculator decCalc = new DecimalCalculator(dec);
        return decCalc.toBinary();
    }

    @Override
    public Hex toHex() {
        return this.getNum();
    }
}
