package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hex;

public interface Convertible {
    Decimal convertToDec();
    Binary convertToBin();
    Hex convertToHex();
}
