package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The RateUnit class is a representation of rate unit value
 * from bit/s to terabit/s. It purpose is to store bits values
 * for all five rate units and support conversion from one unit to another.
 * The static initializer inside the Rate enum class create a look up map
 * useful for getting the Rate enum using a label.
 */
public class RateUnit extends Unit<RateUnit.Rate> {

    /**
     * The Rate in terms of data unit per second to be
     * used in rate conversions.
     */
    public enum Rate {

        BIT_PER_SECOND(1, "bit/s"),
        KILOBIT_PER_SECOND(1e3, "Kbit/s"),
        MEGABIT_PER_SECOND(1e6, "Mbit/s"),
        GIGABIT_PER_SECOND(1e9, "Gbit/s"),
        TERABIT_PER_SECOND(1e12, "Tbit/s");

        /**
         * The bits value of this unit.
         */
        public final double toBits;

        /**
         * The shorten label of this unit enum.
         */
        public final String label;

        private static final Map<String, Rate> LABEL_LOOKUP = new HashMap<>();

        /**
         * This constructor attach the bits value and label
         * to the enum.
         * @param bits The bits value to attach to the enum.
         * @param label The shorten label to be attached to the enum.
         */
        Rate(double bits, String label) {
            this.toBits = bits;
            this.label = label;
        }

        static {
            for (Rate r: values()) {
                LABEL_LOOKUP.put(r.label, r);
            }
        }

        /**
         * This method provide the Rate enum for the
         * corresponding label.
         * @param label The label from bit/s to Tbit/s to get the enum.
         * @return The enum of type Rate.
         */
        public static Rate valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
        }


        @Override
        public String toString() {
            return this.label;
        }
    }

    /**
     * The constructor set the decimal value of this rate unit,
     * as well as the data unit per second that go along with it.
     * @param value The decimal value to be set as the numeric value of this unit.
     * @param unit The rate unit that this decimal value have.
     */
    public RateUnit(String value, Rate unit) {
        super(value, unit);
    }
}
