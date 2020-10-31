package Model;

public class TimeUnit extends Unit<TimeUnit.Time> {

    public enum Time {

        SECOND(1),
        MINUTE(60),
        HOUR(3600),
        DAY(86400),
        WEEK(604800),
        MONTH(2629800),
        YEAR(31557600);

        public final double toSeconds;

        private Time(double seconds) {
            this.toSeconds = seconds;
        }
    }

    public TimeUnit(String value, Time unit) {
        super(value, unit);
    }

    public double getUnitInSecs() {
        return ((Time) this.getUnit()).toSeconds;
    }

    public static double timeConvert(Time from, Time to) {
        return from.toSeconds/to.toSeconds;
    }
}
