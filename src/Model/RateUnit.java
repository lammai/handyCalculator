package Model;

public class RateUnit extends Unit<RateUnit.Rate> {

    private SizeUnit sizeUnit;
    private TimeUnit timeUnit;

    public enum Rate {
        BIT_PER_SECOND(1, "bit/s"),
        KILOBIT_PER_SECOND(1e3, "Kbit/s"),
        MEGABIT_PER_SECOND(1e6, "Mbit/s"),
        GIGABIT_PER_SECOND(1e9, "Gbit/s"),
        TERABIT_PER_SECOND(1e12, "Tbit/s");

        public final double toBits;

        public final String label;

        private Rate(double bits, String label) {
            this.toBits = bits;
            this.label = label;
        }
    }

    public double getUnitInBits() { return ((RateUnit.Rate) this.getUnit()).toBits; }

    public RateUnit(String value, Rate unit) {
        super(value, unit);
    }
}
