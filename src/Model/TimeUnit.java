package Model;

import java.util.HashMap;
import java.util.Map;

public class TimeUnit extends Unit<TimeUnit.Time> {

    public enum Time {

        SECOND(1, "second"),
        MINUTE(60, "minute"),
        HOUR(3600, "hour"),
        DAY(86400, "day"),
        WEEK(604800, "week"),
        MONTH(2629800, "month"),
        YEAR(31557600, "year");

        public final double toSeconds;

        public final String label;

        private static final Map<String, Time> LABEL_LOOKUP = new HashMap<>();

        private Time(double seconds, String label) {
            this.toSeconds = seconds;
            this.label = label;
        }

        static {
            for (Time t: values()) {
                LABEL_LOOKUP.put(t.label, t);
            }
        }

        public static Time valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
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
