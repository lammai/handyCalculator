package Controller;

import Model.RateUnit;
import Model.SizeUnit;
import Model.TimeUnit;

/**
 * This class defines the calculator for producing a Download/Upload time
 * based on a file size and a bandwidth.
 */
public class DownloadUploadCalculator {

    private final SizeUnit sizeU;
    private final RateUnit rate;

    /**
     * The constructor take in a SizeUnit and a RateUnit
     * and set them up accordingly.
     * @param sizeU The SizeUnit to represent the file size.
     * @param rate The RateUnit to represent the bandwidth.
     */
    public DownloadUploadCalculator(SizeUnit sizeU, RateUnit rate) {
        this.sizeU = sizeU;
        this.rate = rate;
    }

    /**
     * This method perform the calculation to find the Download/Upload time needed
     * using the provided file size and bandwidth.
     * @return a String array that contains the calculated amount of time from seconds up to days.
     */
    public String[] calculate() {
        double fileSize = Double.parseDouble(this.sizeU.getValue());
        double bndWidth = Double.parseDouble(this.rate.getValue());

        double unitPerSecond = fileSize * SizeUnit.unitConvert(this.sizeU.getUnit(), this.rate.getUnit()) / bndWidth;
        String day = String.format("%.0f days", Math.floor(unitPerSecond / TimeUnit.Time.DAY.toSeconds));
        String hour = String.format("%.0f hours", Math.floor((unitPerSecond % TimeUnit.Time.DAY.toSeconds)/TimeUnit.Time.HOUR.toSeconds));
        String minute = String.format("%.0f minutes", Math.floor((unitPerSecond % TimeUnit.Time.HOUR.toSeconds)/TimeUnit.Time.MINUTE.toSeconds));
        String second = String.format("%f seconds", unitPerSecond % TimeUnit.Time.MINUTE.toSeconds);

        if (day.equals("0 days") && hour.equals("0 hours") && minute.equals("0 minutes")) return new String[]{second};
        else if (day.equals("0 days") && hour.equals("0 hours")) return new String[]{minute, second};
        else if (day.equals("0 days")) return new String[]{hour, minute, second};
        else return new String[]{day, hour, minute, second};
    }
}
