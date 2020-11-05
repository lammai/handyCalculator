package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The SizeUnit class is a representation of data unit value
 * from bits(b) to terabytes(TB). It purpose is to store bits values
 * for all ten data units and support conversion from one unit to another.
 * The static initializer inside the Size enum class create a look up map
 * useful for getting the Size enum using a label.
 */
public class SizeUnit extends Unit<SizeUnit.Size> {

    /**
     * The Size in terms of data units to be
     * used in data conversions.
     */
    public enum Size {

        BITS(1, "b"),
        KILOBITS(1e3, "kb"),
        MEGABITS(1e6, "mb"),
        GIGABITS(1e9, "gb"),
        TERABITS(1e12, "tb"),
        BYTES(8, "B"),
        KILOBYTES(8e3, "KB"),
        MEGABYTES(8e6, "MB"),
        GIGABYTES(8e9, "GB"),
        TERABYTES(8e12, "TB");

        /**
         * The bits value of this unit.
         */
        public final double toBits;

        /**
         * The shorten label of this unit enum.
         */
        public final String label;

        private static final Map<String, Size> LABEL_LOOKUP = new HashMap<>();

        /**
         * This constructor attach the bits value and label
         * to the enum.
         * @param bits The bits value to attach to the enum.
         * @param label The shorten label to be attached to the enum.
         */
        Size(double bits, String label) {
            this.toBits = bits;
            this.label = label;
        }

        static {
            for (Size s: values()) {
                LABEL_LOOKUP.put(s.label, s);
            }
        }

        /**
         * This method provide the Size enum for the
         * corresponding label.
         * @param label The label from b to TB to get the enum.
         * @return The enum of type Size.
         */
        public static Size valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
        }
    }

    /**
     * The constructor set the decimal value of this data unit,
     * as well as the unit that go along with it.
     * @param value The decimal value to be set as the numeric value of this unit.
     * @param unit The data unit that this decimal value have.
     */
    public SizeUnit(String value, Size unit) {
        super(value, unit);
    }

    /**
     * This method allows for conversion of one Size to another Size.
     * @param from The Size unit to convert from.
     * @param to The Size unit to convert to.
     * @return The conversion factor.
     */
    public static double getConversionFactor(Size from, Size to) { return from.toBits/to.toBits; }

    /**
     * This method allows for conversion of Size unit to a Rate unit.
     * @param from The Size unit to convert from.
     * @param to The Rate unit to convert to.
     * @return The conversion factor.
     */
    public static double getConversionFactor(Size from, RateUnit.Rate to) { return from.toBits/to.toBits; }

    /**
     * This method allows for conversion of Rate unit to a Size unit.
     * @param from The Rate unit to convert from.
     * @param to The Size unit to convert to.
     * @return The conversion factor.
     */
    public static double getConversionFactor(RateUnit.Rate from, Size to) { return from.toBits/to.toBits; }
}
