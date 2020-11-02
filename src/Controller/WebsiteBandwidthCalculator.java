package Controller;

import Model.Decimal;
import Model.SizeUnit;
import Model.TimeUnit;

public class WebsiteBandwidthCalculator {

    private final Decimal view;
    private final TimeUnit.Time viewUnit;
    private final Decimal size;
    private final SizeUnit.Size sizeUnit;
    private final double reFactor;

    public WebsiteBandwidthCalculator(Decimal view, TimeUnit.Time viewUnit, Decimal size, SizeUnit.Size sizeUnit, double reFactor) {
        this.view = view;
        this.viewUnit = viewUnit;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.reFactor = reFactor;
    }

    public String[] calculate() {
        double pgView = Double.parseDouble(this.view.getValue());
        double pgSize = Double.parseDouble(this.size.getValue());

        double bandwidthMbits = (pgView / viewUnit.toSeconds) * (pgSize * SizeUnit.unitConvert(sizeUnit, SizeUnit.Size.MEGABITS));
        double bandwidthGB = (pgView/ TimeUnit.timeConvert(viewUnit, TimeUnit.Time.MONTH)) * (pgSize*SizeUnit.unitConvert(sizeUnit, SizeUnit.Size.GIGABYTES));

        return new String[]{String.format("%.10f Mbits/s", bandwidthMbits),
                            String.format("%.10f GB per month", bandwidthGB),
                            String.format("%.10f Mbits/s", bandwidthMbits*this.reFactor),
                            String.format("%.10f GB per month", bandwidthGB*this.reFactor)};
    }
}
