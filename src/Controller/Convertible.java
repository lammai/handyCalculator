package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

/**
 * This is the interface for Calculator of any type.
 * The particular implementation if left for each Calculator subclasses,
 * but this is the minimal list of possible conversion methods.
 */
public interface Convertible {
    /**
     * This method should return the Decimal object after conversion.
     * @return The converted Decimal.
     */
    Decimal convertToDec();

    /**
     * This method should return the Binary object after conversion.
     * @return The converted Binary.
     */
    Binary convertToBin();

    /**
     * This method should return the Hex object after conversion.
     * @return The converted Hex.
     */
    Hex convertToHex();
}
