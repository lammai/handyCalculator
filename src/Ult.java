import java.util.Map;
import java.util.TreeMap;

public class Ult {

    private Ult() {}

    public static double power(double base, double pow) {
        if (pow == 0) {
            return 1;
        }
        else if (pow == 1) {
            return base;
        }
        else {
            return base * power(base, pow - 1);
        }
    }

    public static double absolute(double num) {
        if (num < 0) {
            return num * -1;
        }
        else
            return num;
    }

    public static String[] parseOperation(String calculation) {
        String mathOperations = "+-*/";
        String[] parseInp = new String[3];

        parseInp[0] = "";
        int index = 0;
        while (mathOperations.indexOf(calculation.charAt(index)) < 0) {
            parseInp[0] += calculation.charAt(index);
            index++;
        }
        parseInp[0] = parseInp[0].trim();
        parseInp[1] = "" + calculation.charAt(index);
        parseInp[2] = calculation.substring(index+1).trim();

        return parseInp;
    }

    public static Map<Integer, String> generateNetMasks() {
        Map<Integer, String> netMasks = new TreeMap<>();
        int start = 128;
        int increment = 64;
        for (int i = 1; i < 9; i++, increment /= 2) {
            netMasks.put(i, start + ".0.0.0");
            netMasks.put((i+8), "255."+ start +".0.0");
            netMasks.put((i+16), "255.255."+ start +".0");
            netMasks.put((i+24), "255.255.255." + start);
            start += increment;
        }
        return netMasks;
    }
}
