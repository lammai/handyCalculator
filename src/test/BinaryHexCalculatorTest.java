import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryHexCalculatorTest {

    @Test
    void testBinaryToDecimal() {    // write better test classes
        long decimal0 = (long)BinaryHexCalculator.numberSystemToDecimal("0", 2);
        long decimal1 = (long)BinaryHexCalculator.numberSystemToDecimal("01", 2);
        long decimal2 = (long)BinaryHexCalculator.numberSystemToDecimal("10", 2);
        long decimal3 = (long)BinaryHexCalculator.numberSystemToDecimal("11", 2);
        long decimal4 = (long)BinaryHexCalculator.numberSystemToDecimal("100", 2);
        long decimal5 = (long)BinaryHexCalculator.numberSystemToDecimal("111", 2);

        assertEquals(0, decimal0);  // maybe use Integer.toBinaryString() ???
        assertEquals(1, decimal1);
        assertEquals(2, decimal2);
        assertEquals(3, decimal3);
        assertEquals(4, decimal4);
        assertEquals(7, decimal5);
    }

    @Test
    void testHexToDecimal() {
        long decimal0 = (long)BinaryHexCalculator.numberSystemToDecimal("0", 16);
        long decimal1 = (long)BinaryHexCalculator.numberSystemToDecimal("1", 16);
        long decimal2 = (long)BinaryHexCalculator.numberSystemToDecimal("2", 16);
        long decimal3 = (long)BinaryHexCalculator.numberSystemToDecimal("B", 16);
        long decimal4 = (long)BinaryHexCalculator.numberSystemToDecimal("e", 16);
        long decimal5 = (long)BinaryHexCalculator.numberSystemToDecimal("3f", 16);

        assertEquals(0, decimal0);
        assertEquals(1, decimal1);
        assertEquals(2, decimal2);
        assertEquals(11, decimal3);
        assertEquals(14, decimal4);
        assertEquals(63, decimal5);
    }
}