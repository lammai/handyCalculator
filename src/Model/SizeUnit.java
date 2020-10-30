package Model;

public class SizeUnit extends Unit<SizeUnit.Size> {

    public enum Size {

        BITS(1),
        KILOBITS(1e3),
        MEGABITS(1e6),
        GIGABITS(1e9),
        TERABITS(1e12),
        BYTES(8),
        KILOBYTES(8e3),
        MEGABYTES(8e6),
        GIGABYTES(8e9),
        TERABYTES(8e12);

        public final double toBits;

        private Size(double bits) {
            this.toBits = bits;
        }
    }

    public SizeUnit(String value, Size unit) {
        super(value, unit);
    }

    public double getUnitInBits() {
        return ((Size) this.getUnit()).toBits;
    }
}
