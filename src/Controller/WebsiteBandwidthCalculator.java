package Controller;

import Model.SizeUnit;
import Model.TimeUnit;

/**
 * This class defines the calculator for producing the bandwidth needed for
 * a certain amount of page view per time unit and page size.
 */
public class WebsiteBandwidthCalculator {

    private final TimeUnit view;
    private final SizeUnit size;
    private final double reFactor;

    /**
     * The constructor take in a TimeUnit and a SizeUnit as well as a redundancy factor
     * and set them up accordingly.
     * @param view The TimeUnit to represent the page view.
     * @param size The SizeUnit to represent the page size.
     * @param reFactor The redundancy factor.
     */
    public WebsiteBandwidthCalculator(TimeUnit view, SizeUnit size, double reFactor) {
        this.view = view;
        this.size = size;
        this.reFactor = reFactor;
    }

    /**
     * This method perform the calculation to find the bandwidth needed
     * using the provided page view, page size, and redundancy factor.
     * @return a String array with the first two elements being the actual bandwidth in Mbit/s and GB/month,
     * the third and fourth elements are bandwidth with redundancy factor.
     */
    public String[] calculate() {
        double pgView = Double.parseDouble(this.view.getValue());
        double pgSize = Double.parseDouble(this.size.getValue());
        double bandwidthMbits = (pgView / view.getUnit().toSeconds) * (pgSize * SizeUnit.getConversionFactor(size.getUnit(), SizeUnit.Size.MEGABITS));
        double bandwidthGB = (pgView/ TimeUnit.timeConversionFactor(view.getUnit(), TimeUnit.Time.MONTH)) * (pgSize*SizeUnit.getConversionFactor(size.getUnit(), SizeUnit.Size.GIGABYTES));

        return new String[]{String.format("%.10f Mbits/s", bandwidthMbits),
                            String.format("%.10f GB per month", bandwidthGB),
                            String.format("%.10f Mbits/s", bandwidthMbits*this.reFactor),
                            String.format("%.10f GB per month", bandwidthGB*this.reFactor)};
    }
}
