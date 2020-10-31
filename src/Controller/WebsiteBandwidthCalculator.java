package Controller;

import Model.Decimal;
import Model.SizeUnit;
import Model.TimeUnit;

public class WebsiteBandwidthCalculator {

    private Decimal view;
    private TimeUnit.Time viewUnit;
    private Decimal size;
    private SizeUnit.Size sizeUnit;
    private int reFactor;

    public WebsiteBandwidthCalculator(Decimal view, TimeUnit.Time viewUnit, Decimal size, SizeUnit.Size sizeUnit, int reFactor) {
        this.view = view;
        this.viewUnit = viewUnit;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.reFactor = reFactor;
    }

    public String[] calculate() {
        double pgView = Double.parseDouble(this.view.getValue());
        double pgSize = Double.parseDouble(this.size.getValue());

        double bandwidthMbits = (pgView/viewUnit.toSeconds) * (pgSize*SizeUnit.unitConvert(sizeUnit, SizeUnit.Size.MEGABITS));
        double bandwidthGB = (pgView/ TimeUnit.timeConvert(viewUnit, TimeUnit.Time.MONTH)) * (pgSize*SizeUnit.unitConvert(sizeUnit, SizeUnit.Size.GIGABYTES));

        return new String[]{String.format("%.12f Mbits/s", bandwidthMbits),
                            String.format("%.12f GB per month", bandwidthGB),
                            String.format("%.12f Mbits/s", bandwidthMbits*this.reFactor),
                            String.format("%.12f GB per month", bandwidthGB*this.reFactor)};
    }
}
