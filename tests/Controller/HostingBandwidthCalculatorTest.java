package Controller;

import Model.Decimal;
import Model.RateUnit;
import Model.SizeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostingBandwidthCalculatorTest {

    private HostingBandwidthCalculator hostCalc1, hostCalc2;

    @BeforeEach
    void setUp() {
        Decimal input = new Decimal("238090239845");
        hostCalc1 = new HostingBandwidthCalculator(input, SizeUnit.Size.GIGABYTES, RateUnit.Rate.KILOBIT_PER_SECOND);
        hostCalc2 = new HostingBandwidthCalculator(input, RateUnit.Rate.KILOBIT_PER_SECOND, SizeUnit.Size.GIGABYTES);
    }

    @Test
    void month2rate() {
        String result = hostCalc1.convert();
        String correctResult = "724283945075.6711 Kbit/s";
        assertEquals(correctResult, result);
    }

    @Test
    void rate2Month() {
        String result = hostCalc2.convert();
        String correctResult = "78266214093.04762 GB per month";
        assertEquals(correctResult, result);
    }
}