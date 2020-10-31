package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

import java.math.BigDecimal;

public class DecimalCalculator extends Calculator<Decimal> {

    public DecimalCalculator(Decimal num) {
        super(num);
    }

    @Override
    public void add(Decimal oNum) {
        double result = Double.parseDouble(new BigDecimal(this.getNum().getValue()).toPlainString())
                + Double.parseDouble(new BigDecimal(oNum.getValue()).toPlainString());
        this.getNum().setValue(String.format("%.0f",result));
    }

    @Override
    public void subtract(Decimal oNum) {
        double result = Double.parseDouble(new BigDecimal(this.getNum().getValue()).toPlainString())
                - Double.parseDouble(new BigDecimal(oNum.getValue()).toPlainString());
        this.getNum().setValue(String.format("%.0f",result));
    }

    @Override
    public void multiply(Decimal oNum) {
        double result = Double.parseDouble(new BigDecimal(this.getNum().getValue()).toPlainString())
                * Double.parseDouble(new BigDecimal(oNum.getValue()).toPlainString());
        this.getNum().setValue(String.format("%.0f",result));
    }

    @Override
    public String[] divide(Decimal oNum) {
        double result = Double.parseDouble(new BigDecimal(this.getNum().getValue()).toPlainString())
                / Double.parseDouble(new BigDecimal(oNum.getValue()).toPlainString());
        double remainder = Double.parseDouble(new BigDecimal(this.getNum().getValue()).toPlainString())
                % Double.parseDouble(new BigDecimal(oNum.getValue()).toPlainString());
        this.getNum().setValue(String.format("%.0f", Math.floor(result)));
        return new String[]{String.format("%.0f", remainder)};
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
