package Model;

import java.util.HashMap;
import java.util.Map;

public class SizeUnit extends Unit<SizeUnit.Size> {

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

        public final double toBits;

        public final String label;

        private static final Map<String, Size> LABEL_LOOKUP = new HashMap<>();

        private Size(double bits, String label) {
            this.toBits = bits;
            this.label = label;
        }

        static {
            for (Size s: values()) {
                LABEL_LOOKUP.put(s.label, s);
            }
        }

        public static Size valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
        }
    }

    public SizeUnit(String value, Size unit) {
        super(value, unit);
    }

    public double getUnitInBits() { return ((Size) this.getUnit()).toBits; }

    public static double unitConvert(Size from, Size to) {
        return from.toBits/to.toBits;
    }

    public static double unitConvert(Size from, RateUnit.Rate to) {
        return from.toBits/to.toBits;
    }

    public static double unitConvert(RateUnit.Rate from, Size to) {
        return from.toBits/to.toBits;
    }
}
