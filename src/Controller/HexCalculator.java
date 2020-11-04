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
        Decimal hex = this.convertToDec();
        new DecimalCalculator(hex).add(new HexCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(hex).convertToHex().getValue());
    }

    @Override
    public void subtract(Hex oNum) {
        Decimal hex = this.convertToDec();
        new DecimalCalculator(hex).subtract(new HexCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(hex).convertToHex().getValue());
    }

    @Override
    public void multiply(Hex oNum) {
        Decimal hex = this.convertToDec();
        new DecimalCalculator(hex).multiply(new HexCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(hex).convertToHex().getValue());
    }

    @Override
    public String[] divide(Hex oNum) {
        Decimal hex = this.convertToDec();
        String[] remainder = new String[2];     // Remainder[0] = Decimal remainder     Remainder[1] = Hex remainder
        remainder[0] = new DecimalCalculator(hex).divide(new HexCalculator(oNum).convertToDec())[0];
        remainder[1] = new DecimalCalculator(new Decimal(remainder[0])).convertToHex().getValue();
        this.getNum().setValue(new DecimalCalculator(hex).convertToHex().getValue());
        return remainder;
    }

    @Override
    public Decimal convertToDec() {
        return new Decimal(toDecimal());
    }

    @Override
    public Binary convertToBin() {
        Decimal dec = this.convertToDec();
        DecimalCalculator decCalc = new DecimalCalculator(dec);
        return decCalc.convertToBin();
    }

    @Override
    public Hex convertToHex() {
        return this.getNum();
    }
}
