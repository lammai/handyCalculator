package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The TimeUnit class is a representation of time unit value
 * from second to year. It purpose is to store seconds values
 * for all seven time units and support conversion from one unit to another.
 * The static initializer inside the Time enum class create a look up map
 * useful for getting a Time enum using a label.
 */
public class TimeUnit extends Unit<TimeUnit.Time> {

    /**
     * The Time unit to be
     * used in frequency conversions.
     */
    public enum Time {

        SECOND(1, "second"),
        MINUTE(60, "minute"),
        HOUR(3600, "hour"),
        DAY(86400, "day"),
        WEEK(604800, "week"),
        MONTH(2629800, "month"),
        YEAR(31557600, "year");

        /**
         * The seconds value of this unit.
         */
        public final double toSeconds;

        /**
         * The String label of this time enum.
         */
        public final String label;

        private static final Map<String, Time> LABEL_LOOKUP = new HashMap<>();

        /**
         * This constructor attach the seconds value and label
         * to the enum.
         * @param seconds The seconds value to attach to the enum.
         * @param label The label to be attached to the enum.
         */
        Time(double seconds, String label) {
            this.toSeconds = seconds;
            this.label = label;
        }

        static {
            for (Time t: values()) {
                LABEL_LOOKUP.put(t.label, t);
            }
        }

        /**
         * This method provide the Time enum for the
         * corresponding label.
         * @param label The label from second to year to get the enum.
         * @return The enum of type Time.
         */
        public static Time valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
        }
    }

    /**
     * The constructor set the decimal value of this time unit,
     * as well as the unit that go along with it.
     * @param value The decimal value to be set as the numeric value of this unit.
     * @param unit The time unit that this decimal value have.
     */
    public TimeUnit(String value, Time unit) {
        super(value, unit);
    }

    /**
     * This method allows for conversion of a Time unit to another Time unit.
     * @param from The Time unit to convert from.
     * @param to The Time unit to convert to.
     * @return The conversion factor.
     */
    public static double timeConvert(Time from, Time to) {
        return from.toSeconds/to.toSeconds;
    }
}
