package Controller;

import Model.Decimal;
import Model.SizeUnit;
import Model.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteBandwidthCalculatorTest {

    private WebsiteBandwidthCalculator webCalc;

    @BeforeEach
    void setUp() {
        TimeUnit pageView = new TimeUnit("92273", TimeUnit.Time.YEAR);
        SizeUnit pageSize = new SizeUnit("22", SizeUnit.Size.TERABYTES);
        webCalc = new WebsiteBandwidthCalculator(pageView, pageSize, 2);
    }

    @Test
    void webBandwidth() {
        String[] result = webCalc.calculate();
        String[] correctResults = { "514616.0671280452 Mbits/s", "169167166.6666667000 GB per month", "1029232.1342560904 Mbits/s", "338334333.3333334000 GB per month"};
        assertEquals(Arrays.toString(correctResults), Arrays.toString(result));
    }
}