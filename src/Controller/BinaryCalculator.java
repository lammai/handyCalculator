package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

import java.math.BigDecimal;

public class BinaryCalculator extends Calculator<Binary> {

    public BinaryCalculator(Binary value) {
        super(value);
    }

    @Override
    public void add(Binary oNum) {
        Decimal bin = this.convertToDec();
        new DecimalCalculator(bin).add(new BinaryCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(bin).convertToBin().getValue());
    }

    @Override
    public void subtract(Binary oNum) {
        Decimal bin = this.convertToDec();
        new DecimalCalculator(bin).subtract(new BinaryCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(bin).convertToBin().getValue());
    }

    @Override
    public void multiply(Binary oNum) {
        Decimal bin = this.convertToDec();
        new DecimalCalculator(bin).multiply(new BinaryCalculator(oNum).convertToDec());
        this.getNum().setValue(new DecimalCalculator(bin).convertToBin().getValue());
    }

    @Override
    public String[] divide(Binary oNum) {
        Decimal bin = this.convertToDec();
        String[] remainder = new String[2];
        remainder[0] = new DecimalCalculator(bin).divide(new BinaryCalculator(oNum).convertToDec())[0]; // if these 2 swap result in error
        remainder[1] = new DecimalCalculator(new Decimal(remainder[0])).convertToBin().getValue();
        this.getNum().setValue(new DecimalCalculator(bin).convertToBin().getValue());
        return remainder;
    }

    @Override
    public Decimal convertToDec() {
        return new Decimal(toDecimal());
    }

    @Override
    public Binary convertToBin() {
        return this.getNum();
    }

    @Override
    public Hex convertToHex() {
        Decimal dec = this.convertToDec();
        DecimalCalculator decCalc = new DecimalCalculator(dec);
        return decCalc.convertToHex();
    }
}
