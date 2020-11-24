package Controller;

import Model.RateUnit;
import Model.SizeUnit;
import Model.TimeUnit;
import java.math.BigDecimal;

/**
 * This class defines the calculator for converting a monthly data usage to
 * a bandwidth value or vice versa.
 */
public class HostingBandwidthCalculator {

    private final SizeUnit monthlyUsage;
    private final RateUnit bandwidth;

    /**
     * This constructor take in a SizeUnit and a Rate enum.
     * This constructor will be used when the user want to convert
     * from monthly usage to bandwidth.
     * @param monthlyUsage The SizeUnit representation of monthly usage.
     * @param bandwidthUnit The Rate enum represent the bandwidth unit to convert to.
     */
    public HostingBandwidthCalculator(SizeUnit monthlyUsage, RateUnit.Rate bandwidthUnit) {
        this.monthlyUsage = monthlyUsage;
        this.bandwidth = new RateUnit("0", bandwidthUnit);
    }

    /**
     * This constructor take in a RateUnit and a Size enum.
     * This constructor will be used when the user want to convert
     * from bandwidth to monthly usage.
     * @param bandwidth The RateUnit representation of the bandwidth.
     * @param usageUnit The Size enum represent the monthly usage unit to convert to.
     */
    public HostingBandwidthCalculator(RateUnit bandwidth, SizeUnit.Size usageUnit) {
        this.bandwidth = bandwidth;
        this.monthlyUsage = new SizeUnit("0", usageUnit);
    }

    /**
     * This method figuring out which conversion to perform based on the values that was set
     * in by the constructor. It then return the converted result as a String.
     * @return The result as a String with unit included.
     */
    public String convert() {
        if (bandwidth.getValue().matches("[0]+")) {
            double usage = Double.parseDouble(new BigDecimal(monthlyUsage.getValue()).toPlainString());
            String result = String.format("%f", usage * SizeUnit.getConversionFactor(monthlyUsage.getUnit(), bandwidth.getUnit()) / TimeUnit.Time.MONTH.toSeconds);
            result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result;
            return String.format("%s %s", result, bandwidth.getUnit());
        } else {
            double usage = Double.parseDouble(new BigDecimal(bandwidth.getValue()).toPlainString());
            String result = String.format("%f", usage * SizeUnit.getConversionFactor(bandwidth.getUnit(), monthlyUsage.getUnit()) * TimeUnit.Time.MONTH.toSeconds);
            result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result;
            return String.format("%s %s", result, monthlyUsage.getUnit() + " per month");
        }
    }
}
