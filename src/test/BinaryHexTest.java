import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryHexTest {

    @Test
    void testBinaryToDecimal() {    // write better test classes
        long decimal0 = (long) BinaryHex.biHex2Decimal("0", 2);
        long decimal1 = (long) BinaryHex.biHex2Decimal("01", 2);
        long decimal2 = (long) BinaryHex.biHex2Decimal("10", 2);
        long decimal3 = (long) BinaryHex.biHex2Decimal("11", 2);
        long decimal4 = (long) BinaryHex.biHex2Decimal("100", 2);
        long decimal5 = (long) BinaryHex.biHex2Decimal("111", 2);

        assertEquals(0, decimal0);  // maybe use Integer.toBinaryString() ???
        assertEquals(1, decimal1);
        assertEquals(2, decimal2);
        assertEquals(3, decimal3);
        assertEquals(4, decimal4);
        assertEquals(7, decimal5);
    }

    @Test
    void testHexToDecimal() {
        long decimal0 = (long) BinaryHex.biHex2Decimal("0", 16);
        long decimal1 = (long) BinaryHex.biHex2Decimal("1", 16);
        long decimal2 = (long) BinaryHex.biHex2Decimal("2", 16);
        long decimal3 = (long) BinaryHex.biHex2Decimal("B", 16);
        long decimal4 = (long) BinaryHex.biHex2Decimal("e", 16);
        long decimal5 = (long) BinaryHex.biHex2Decimal("3f", 16);

        assertEquals(0, decimal0);
        assertEquals(1, decimal1);
        assertEquals(2, decimal2);
        assertEquals(11, decimal3);
        assertEquals(14, decimal4);
        assertEquals(63, decimal5);
    }
}