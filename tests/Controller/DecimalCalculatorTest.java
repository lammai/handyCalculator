package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

class DecimalCalculatorTest {

    private long input1, input2;
    private int inputInt1, inputInt2;
    private Decimal num1, num2, numInt1, numInt2;

    @BeforeEach
    void setUp() {
        Random rand = new Random();
        this.input1 = rand.nextLong();
        this.input2 = rand.nextLong();
        this.inputInt1 = rand.nextInt(Integer.MAX_VALUE);
        this.inputInt2 = rand.nextInt(Integer.MAX_VALUE);
        this.num1 = new Decimal(String.format("%d", input1));
        this.num2 = new Decimal(String.format("%d", input2));
        this.numInt1 = new Decimal(String.format("%d", inputInt1));
        this.numInt2 = new Decimal(String.format("%d", inputInt2));
    }

    @Test
    void add2Decimal() {
        new DecimalCalculator(num1).add(num2);
        assertEquals(new BigDecimal(input1).add(new BigDecimal(input2)).toPlainString(), num1.getValue());
    }

    @Test
    void subtract2Decimal() {
        new DecimalCalculator(num1).subtract(num2);
        assertEquals(new BigDecimal(input1).subtract(new BigDecimal(input2)).toPlainString(), num1.getValue());
    }

    @Test
    void multiply2Decimal() {
        new DecimalCalculator(num1).multiply(num2);
        assertEquals(new BigDecimal(input1).multiply(new BigDecimal(input2)).toPlainString(), num1.getValue());
    }

    @Test
    void divide2Decimal() {
        String[] remainder = new DecimalCalculator(num1).divide(num2);
        assertEquals(new BigDecimal(input1).divide(new BigDecimal(input2), RoundingMode.FLOOR).toPlainString(), num1.getValue());
        assertEquals(new BigDecimal(input1).remainder(new BigDecimal(input2)).toPlainString(), remainder[0]);
    }

    @Test
    void convert2Binary() {
        Binary num1Bin = new DecimalCalculator(numInt1).toBinary();
        Binary num2Bin = new DecimalCalculator(numInt2).toBinary();

        assertEquals(Long.toBinaryString(inputInt1), num1Bin.getValue());
        assertEquals(Long.toBinaryString(inputInt2), num2Bin.getValue());
    }

    @Test
    void convert2Hex() {
       Hex num1Hex = new DecimalCalculator(numInt1).toHex();
       Hex num2Hex = new DecimalCalculator(numInt2).toHex();

        assertEquals(Long.toHexString(inputInt1).toUpperCase(), num1Hex.getValue());
        assertEquals(Long.toHexString(inputInt2).toUpperCase(), num2Hex.getValue());
    }
}