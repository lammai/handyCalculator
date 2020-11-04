package Controller;

import Model.RateUnit;
import Model.SizeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DownloadUploadCalculatorTest {

    private SizeUnit size;
    private RateUnit bandwidth;

    @BeforeEach
    void setUp() {
        size = new SizeUnit("23408904589", SizeUnit.Size.TERABYTES);
        bandwidth = new RateUnit("482934574358", RateUnit.Rate.MEGABIT_PER_SECOND);
    }

    @Test
    void downloadUploadCalculation() {
        String[] correctResult = {"4 days", "11 hours", "42 minutes", "57.654894 seconds"};
        String[] correctResult1 = {"6 minutes", "27.777655 seconds"};
        String[] correctResult2 = {"0.000388 seconds"};

        String[] result = new DownloadUploadCalculator(size, bandwidth).calculate();
        assertEquals(Arrays.toString(correctResult), Arrays.toString(result));

        size.setUnit(SizeUnit.Size.KILOBYTES);
        bandwidth.setUnit(RateUnit.Rate.BIT_PER_SECOND);
        String[] result1 = new DownloadUploadCalculator(size, bandwidth).calculate();
        assertEquals(Arrays.toString(correctResult1), Arrays.toString(result1));

        size.setUnit(SizeUnit.Size.MEGABYTES);
        bandwidth.setUnit(RateUnit.Rate.GIGABIT_PER_SECOND);
        String[] result2 = new DownloadUploadCalculator(size, bandwidth).calculate();
        assertEquals(Arrays.toString(correctResult2), Arrays.toString(result2));
    }
}