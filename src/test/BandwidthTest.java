import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class compare the unit conversion results of the Bandwidth class with correct answers.
 */
class BandwidthTest {

    /**
     * Create three test cases to test for
     * converting bit to all other units,
     * converting Terabytes to all other units, and
     * converting Bytes to all other units.
     */
    @Test
    void testUnitConversion() {
        double input1 = 5290482534.0;
        double input2 = 293828534756.9;
        double input3 = 92305876942094f;

        assertEquals(String.format("%.9f",input1/1000), String.format("%.9f", input1*(Bandwidth.unitConvert("b", "kb"))));
        assertEquals(String.format("%.9f",input1/1e6), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "mb"))));
        assertEquals(String.format("%.9f",input1/1e9), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "gb"))));
        assertEquals(String.format("%.9f",input1/1e12), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "tb"))));
        assertEquals(String.format("%.9f",input1/8), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "B"))));
        assertEquals(String.format("%.9f",input1/8000), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "KB"))));
        assertEquals(String.format("%.9f",input1/8e6), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "MB"))));
        assertEquals(String.format("%.9f",input1/8e9), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "GB"))));
        assertEquals(String.format("%.9f",input1/8e12), String.format("%.9f",input1*(Bandwidth.unitConvert("b", "TB"))));

        assertEquals(String.format("%.9f",input2*8e12), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "b"))));
        assertEquals(String.format("%.9f",input2*8e9), String.format("%.9f", input2*(Bandwidth.unitConvert("TB", "kb"))));
        assertEquals(String.format("%.9f",input2*8e6), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "mb"))));
        assertEquals(String.format("%.9f",input2*8000), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "gb"))));
        assertEquals(String.format("%.9f",input2*8), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "tb"))));
        assertEquals(String.format("%.9f",input2*1e12), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "B"))));
        assertEquals(String.format("%.9f",input2*1e9), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "KB"))));
        assertEquals(String.format("%.9f",input2*1e6), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "MB"))));
        assertEquals(String.format("%.9f",input2*1000), String.format("%.9f",input2*(Bandwidth.unitConvert("TB", "GB"))));

        assertEquals(String.format("%.9f",input3*8), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "b"))));
        assertEquals(String.format("%.9f",input3/125), String.format("%.9f", input3*(Bandwidth.unitConvert("B", "kb"))));
        assertEquals(String.format("%.9f",input3/125000), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "mb"))));
        assertEquals(String.format("%.9f",input3/1.25e8), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "gb"))));
        assertEquals(String.format("%.9f",input3/1.25e11), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "tb"))));
        assertEquals(String.format("%.9f",input3/1e12), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "TB"))));
        assertEquals(String.format("%.9f",input3/1000), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "KB"))));
        assertEquals(String.format("%.9f",input3/1e6), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "MB"))));
        assertEquals(String.format("%.9f",input3/1e9), String.format("%.9f",input3*(Bandwidth.unitConvert("B", "GB"))));
    }
}