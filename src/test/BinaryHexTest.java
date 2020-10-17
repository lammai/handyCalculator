import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class compare the results of the BinaryHex class with correct answers according to
 * the wrapper methods and Calculator.net.
 */
class BinaryHexTest {

    /**
     * Create three test cases to test for 0,
     * one extreme case, and one case in between to test
     * the Binary to decimal method. The results should match
     * the wrapper class results.
     */
    @Test
    void testBinary2Decimal() {
        String input1 = "0";
        String input2 = "1110101010000010101001010110";
        String input3 = "1010110101100101010101100101010101011010110010110111100";
        assertEquals(Long.toString(Long.parseLong(input1, 2)), (Long.toString((long) BinaryHex.biHex2Decimal(input1, 2))));
        assertEquals(Long.toString(Long.parseLong(input2, 2)), (Long.toString((long) BinaryHex.biHex2Decimal(input2, 2))));
        assertEquals(Long.toString(Long.parseLong(input3, 2)), (Long.toString((long) BinaryHex.biHex2Decimal(input3, 2))));
    }

    /**
     * Create three test cases to test for 0,
     * one extreme case, and one case in between to test
     * the Hex to decimal method. The results should match
     * the wrapper class results.
     */
    @Test
    void testHex2Decimal() {
        String input1 = "0";
        String input2 = "f563f";
        String input3 = "087fd4bceeb8c";

        assertEquals(Long.toString(Long.parseLong(input1, 16)), String.format("%.0f",BinaryHex.biHex2Decimal(input1, 16)));
        assertEquals(Long.toString(Long.parseLong(input2, 16)), String.format("%.0f",BinaryHex.biHex2Decimal(input2, 16)));
        assertEquals(Long.toString(Long.parseLong(input3, 16)), String.format("%.0f",BinaryHex.biHex2Decimal(input3, 16)));
    }

    /**
     * Create three test cases to test for 0,
     * one extreme case, and one case in between to test
     * the decimal to Binary and Hex method. The results should match
     * the wrapper class results.
     */
    @Test
    void testDecimalHex2Binary() {
        String input1 = "0";
        String input2 = "9932822334";
        String input3 = "2147483647214748";

        assertEquals(Long.toBinaryString(Long.parseLong(input1)), BinaryHex.decimal2BiHex(Double.parseDouble(input1), 2));
        assertEquals(Long.toBinaryString(Long.parseLong(input2)), BinaryHex.decimal2BiHex(Double.parseDouble(input2), 2));
        assertEquals(Long.toBinaryString(Long.parseLong(input3)), BinaryHex.decimal2BiHex(Double.parseDouble(input3), 2));
        assertEquals(Long.toHexString(Long.parseLong(input1)), BinaryHex.decimal2BiHex(Double.parseDouble(input1), 16).toLowerCase());
        assertEquals(Long.toHexString(Long.parseLong(input2)), BinaryHex.decimal2BiHex(Double.parseDouble(input2), 16).toLowerCase());
        assertEquals(Long.toHexString(Long.parseLong(input3)), BinaryHex.decimal2BiHex(Double.parseDouble(input3), 16).toLowerCase());
    }

    /**
     * Create 2 test cases to test
     * the four basic calculations. The results
     * should match the wrapper class results. For subtraction however,
     * the result should match Calculator.net because the wrapper class doesn't provide
     * correct result for subtraction.
     */
    @Test
    void testCalculations() {
        String var1 = "1010110101100101010101100101";
        String var2 = "1010111101011001000111001100";
        String hexVar1 = "81fbf18";
        String hexVar2 = "f16a6fb";

        assertEquals(Long.toBinaryString(Long.parseLong(var1, 2)+Long.parseLong(var2, 2)), BinaryHex.calculation(var1, "+", var2, 2));
        assertEquals(Long.toHexString(Long.parseLong(hexVar1, 16)+Long.parseLong(hexVar2, 16)), BinaryHex.calculation(hexVar1, "+", hexVar2, 16).toLowerCase());

        assertEquals(Long.toBinaryString(Long.parseLong(var1, 2)*Long.parseLong(var2, 2)), BinaryHex.calculation(var1, "*", var2, 2));
        assertEquals(Long.toHexString(Long.parseLong(hexVar1, 16)*Long.parseLong(hexVar2, 16)), BinaryHex.calculation(hexVar1, "*", hexVar2, 16).toLowerCase());

        assertEquals(Long.toBinaryString(Long.parseLong(var1, 2)/Long.parseLong(var2, 2)), BinaryHex.calculation(var1, "/", var2, 2));
        assertEquals(Long.toHexString(Long.parseLong(hexVar1, 16)/Long.parseLong(hexVar2, 16)), BinaryHex.calculation(hexVar1, "/", hexVar2, 16).toLowerCase());

        assertEquals("-111110011110001100111", BinaryHex.calculation(var1, "-", var2, 2));
        assertEquals("-6F6E7E3", BinaryHex.calculation(hexVar1, "-", hexVar2, 16));
    }
}