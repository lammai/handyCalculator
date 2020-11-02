package Controller;

import Model.Decimal;
import Model.RateUnit;
import Model.SizeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DownloadUploadCalculatorTest {

    private DownloadUploadCalculator downloadUploadCalculator, downloadUploadCalculator1, downloadUploadCalculator2;

    @BeforeEach
    void setUp() {
        Decimal size = new Decimal("23408904589");
        Decimal bandwidth = new Decimal("482934574358");
        downloadUploadCalculator = new DownloadUploadCalculator(size, SizeUnit.Size.TERABYTES, bandwidth, RateUnit.Rate.MEGABIT_PER_SECOND);
        downloadUploadCalculator1 = new DownloadUploadCalculator(size, SizeUnit.Size.KILOBYTES, bandwidth, RateUnit.Rate.BIT_PER_SECOND);
        downloadUploadCalculator2 = new DownloadUploadCalculator(size, SizeUnit.Size.MEGABYTES, bandwidth, RateUnit.Rate.GIGABIT_PER_SECOND);
    }

    @Test
    void downloadUploadCalculation() {
        String[] result = downloadUploadCalculator.calculate();
        String[] result1 = downloadUploadCalculator1.calculate();
        String[] result2 = downloadUploadCalculator2.calculate();
        String[] correctResult = {"4 days", "11 hours", "42 minutes", "57.654894 seconds"};
        String[] correctResult1 = {"6 minutes", "27.777655 seconds"};
        String[] correctResult2 = {"0.000388 seconds"};
        assertEquals(Arrays.toString(correctResult), Arrays.toString(result));
        assertEquals(Arrays.toString(correctResult1), Arrays.toString(result1));
        assertEquals(Arrays.toString(correctResult2), Arrays.toString(result2));
    }
}