package Model;

import java.util.HashMap;
import java.util.Map;

public class RateUnit extends Unit<RateUnit.Rate> {

    public enum Rate {

        BIT_PER_SECOND(1, "bit/s", "b"),
        KILOBIT_PER_SECOND(1e3, "Kbit/s", "kb"),
        MEGABIT_PER_SECOND(1e6, "Mbit/s", "mb"),
        GIGABIT_PER_SECOND(1e9, "Gbit/s", "gb"),
        TERABIT_PER_SECOND(1e12, "Tbit/s", "tb");

        public final double toBits;

        public final String label;

        public final String sizeEquivalence;

        private static final Map<String, Rate> LABEL_LOOKUP = new HashMap<>();
        private static final Map<String, Rate> SIZELABEL_LOOKUP = new HashMap<>();

        private Rate(double bits, String label, String sizeEquivalence) {
            this.toBits = bits;
            this.label = label;
            this.sizeEquivalence = sizeEquivalence;
        }

        static {
            for (Rate r: values()) {
                LABEL_LOOKUP.put(r.label, r);
                SIZELABEL_LOOKUP.put(r.sizeEquivalence, r);
            }
        }

        public static Rate valueOfLabel(String label) {
            return LABEL_LOOKUP.get(label);
        }

        public static Rate valueOfSizeLabel(String label) {
            return SIZELABEL_LOOKUP.get(label);
        }
    }

    public double getUnitInBits() { return ((Rate) this.getUnit()).toBits; }

    public RateUnit(String value, Rate unit) {
        super(value, unit);
    }
}
