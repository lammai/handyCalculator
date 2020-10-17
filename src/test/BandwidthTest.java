import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BandwidthTest {

    @Test
    void testUnitConversion() {
        double input = 5290482534.0;

        assertEquals(String.format("%.9f",input/1000), String.format("%.9f", input*(Bandwidth.unitConvert("b", "kb"))));
        assertEquals(String.format("%.9f",input/1e6), String.format("%.9f",input*(Bandwidth.unitConvert("b", "mb"))));
        assertEquals(String.format("%.9f",input/1e9), String.format("%.9f",input*(Bandwidth.unitConvert("b", "gb"))));
        assertEquals(String.format("%.9f",input/1e12), String.format("%.9f",input*(Bandwidth.unitConvert("b", "tb"))));
        assertEquals(String.format("%.9f",input/8), String.format("%.9f",input*(Bandwidth.unitConvert("b", "B"))));
        assertEquals(String.format("%.9f",input/8000), String.format("%.9f",input*(Bandwidth.unitConvert("b", "KB"))));
        assertEquals(String.format("%.9f",input/8e6), String.format("%.9f",input*(Bandwidth.unitConvert("b", "MB"))));
        assertEquals(String.format("%.9f",input/8e9), String.format("%.9f",input*(Bandwidth.unitConvert("b", "GB"))));
        assertEquals(String.format("%.9f",input/8e12), String.format("%.9f",input*(Bandwidth.unitConvert("b", "TB"))));

        assertEquals(String.format("%.9f",input*8e12), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "b"))));
        assertEquals(String.format("%.9f",input*8e9), String.format("%.9f", input*(Bandwidth.unitConvert("TB", "kb"))));
        assertEquals(String.format("%.9f",input*8e6), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "mb"))));
        assertEquals(String.format("%.9f",input*8000), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "gb"))));
        assertEquals(String.format("%.9f",input*8), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "tb"))));
        assertEquals(String.format("%.9f",input*1e12), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "B"))));
        assertEquals(String.format("%.9f",input*1e9), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "KB"))));
        assertEquals(String.format("%.9f",input*1e6), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "MB"))));
        assertEquals(String.format("%.9f",input*1000), String.format("%.9f",input*(Bandwidth.unitConvert("TB", "GB"))));
    }
}