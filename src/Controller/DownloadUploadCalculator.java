package Controller;

import Model.Decimal;
import Model.RateUnit;
import Model.SizeUnit;
import Model.TimeUnit;

public class DownloadUploadCalculator {

    private final Decimal size;
    private final SizeUnit.Size sizeUnit;
    private final Decimal bandwidth;
    private final RateUnit.Rate bandwidthUnit;

    public DownloadUploadCalculator(Decimal size, SizeUnit.Size sizeUnit, Decimal bandwidth, RateUnit.Rate bandwidthUnit) {
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.bandwidth = bandwidth;
        this.bandwidthUnit = bandwidthUnit;
    }

    public String[] calculate() {
        double fileSize = Double.parseDouble(this.size.getValue());
        double bndWidth = Double.parseDouble(this.bandwidth.getValue());

        double unitPerSecond = fileSize * SizeUnit.unitConvert(this.sizeUnit, this.bandwidthUnit) / bndWidth;

        return new String[]{String.format("%.0f days", unitPerSecond / TimeUnit.Time.DAY.toSeconds),
                String.format("%.0f hours", (unitPerSecond % TimeUnit.Time.DAY.toSeconds)/TimeUnit.Time.HOUR.toSeconds),
                String.format("%.0f minutes", (unitPerSecond % TimeUnit.Time.HOUR.toSeconds)/TimeUnit.Time.MINUTE.toSeconds),
                String.format("%.0f seconds", unitPerSecond % TimeUnit.Time.MINUTE.toSeconds)};
    }
}
