package Controller;

import Model.Binary;
import Model.Decimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    private int inputInt1, inputInt2;
    private Binary numInt1, numInt2;

    @BeforeEach
    void setUp() {
        Random rand = new Random();
        this.inputInt1 = rand.nextInt(Integer.MAX_VALUE);
        this.inputInt2 = rand.nextInt(Integer.MAX_VALUE);
        this.numInt1 = new Binary(Long.toBinaryString(inputInt1));
        this.numInt2 = new Binary(Long.toBinaryString(inputInt2));
    }

    @Test
    void add2Binary() {
        new BinaryCalculator(numInt1).add(numInt2);
        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).add(new BigDecimal(inputInt2)).longValueExact()), numInt1.getValue());
    }

    @Test
    void subtract2Binary() {
        new BinaryCalculator(numInt1).subtract(numInt2);
        assertEquals(new BigDecimal(inputInt1).subtract(new BigDecimal(inputInt2)).toPlainString(),
                String.format("%s", new BigDecimal(new BinaryCalculator(numInt1).toDecimal().getValue()).toPlainString()));
    }

    @Test
    void multiply2Binary() {
        new BinaryCalculator(numInt1).multiply(numInt2);
        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).multiply(new BigDecimal(inputInt2)).longValueExact()), numInt1.getValue());
    }

    @Test
    void divide2Binary() {
        String[] remainder = new BinaryCalculator(numInt1).divide(numInt2);
        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).divide(new BigDecimal(inputInt2), RoundingMode.FLOOR).longValueExact()), numInt1.getValue());
        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).remainder(new BigDecimal(inputInt2)).longValueExact()), remainder[1]);
    }

    @Test
    void convert2Decimal() {
        Decimal convertedDec = new BinaryCalculator(numInt1).toDecimal();
        assertEquals(inputInt1+"", new BigDecimal(convertedDec.getValue()).toPlainString());
    }
}