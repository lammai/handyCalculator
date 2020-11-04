package Controller;

import Model.Decimal;
import Model.Hex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class HexCalculatorTest {

    private int input1, input2;
    private Hex num1, num2;

    @BeforeEach
    void setUp() {
        Random rand = new Random();
        this.input1 = rand.nextInt(Integer.MAX_VALUE);
        this.input2 = rand.nextInt(Integer.MAX_VALUE);
        this.num1 = new Hex(Long.toHexString(input1));
        this.num2 = new Hex(Long.toHexString(input2));
    }

    @Test
    void add2Hex() {
        new HexCalculator(num1).add(num2);
        assertEquals(Long.toHexString(new BigDecimal(input1).add(new BigDecimal(input2)).longValue()).toUpperCase(), num1.getValue());
    }

    @Test
    void subtract2Hex() {
        new HexCalculator(num1).subtract(num2);
        String result = num1.getValue();
        if (num1.getValue().charAt(0) == '-')
            result = result.substring(1);
        assertEquals(Long.toHexString(new BigDecimal(input1).subtract(new BigDecimal(input2)).abs().longValueExact()).toUpperCase(), result);
    }

    @Test
    void multiply2Hex() {
        new HexCalculator(num1).multiply(num2);
        assertEquals(Long.toHexString(new BigDecimal(input1).multiply(new BigDecimal(input2)).longValue()).toUpperCase(), num1.getValue());
    }

    @Test
    void divide2Hex() {
        String[] remainder = new HexCalculator(num1).divide(num2);
        assertEquals(Long.toHexString(new BigDecimal(input1).divide(new BigDecimal(input2), RoundingMode.FLOOR).longValueExact()), num1.getValue());
        assertEquals(Long.toHexString(new BigDecimal(input1).remainder(new BigDecimal(input2)).longValueExact()).toUpperCase(), remainder[1]);
    }

    @Test
    void convert2Decimal() {
        Decimal convertedDec = new HexCalculator(num1).convertToDec();
        assertEquals(input1+"", new BigDecimal(convertedDec.getValue()).toPlainString());
    }
}