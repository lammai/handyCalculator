package Controller;

import Model.Decimal;
import Model.RateUnit;
import Model.SizeUnit;
import Model.TimeUnit;

import java.math.BigDecimal;

public class HostingBandwidthCalculator {

    private Decimal monthlyUsage;
    private SizeUnit.Size usageUnit;
    private Decimal bandwidth;
    private RateUnit.Rate bandwidthUnit;

    public HostingBandwidthCalculator(Decimal monthlyUsage, SizeUnit.Size usageUnit, RateUnit.Rate bandwidthUnit) {
        this.monthlyUsage = monthlyUsage;
        this.usageUnit = usageUnit;
        this.bandwidth = new Decimal("0");
        this.bandwidthUnit = bandwidthUnit;
    }

    public HostingBandwidthCalculator(Decimal bandwidth, RateUnit.Rate bandwidthUnit, SizeUnit.Size usageUnit) {
        this.monthlyUsage = new Decimal("0");
        this.usageUnit = usageUnit;
        this.bandwidth = bandwidth;
        this.bandwidthUnit = bandwidthUnit;
    }

    public String convert() {
        if (bandwidth.getValue().matches("[0]+")) {
            double usage = Double.parseDouble(new BigDecimal(monthlyUsage.getValue()).toPlainString());
            return String.format("%f %s", usage * SizeUnit.unitConvert(usageUnit, bandwidthUnit) / TimeUnit.Time.MONTH.toSeconds, bandwidthUnit.label);
        } else {
            double usage = Double.parseDouble(new BigDecimal(bandwidth.getValue()).toPlainString());
            return String.format("%f %s", usage * SizeUnit.unitConvert(bandwidthUnit, usageUnit) * TimeUnit.Time.MONTH.toSeconds, usageUnit.label);
        }
    }
}
