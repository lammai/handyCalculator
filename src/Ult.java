import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ult {

    private static final Scanner scanner = new Scanner(System.in);

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

    public static String validateInput(String input, String regex) {
        while (input == null || !input.matches(regex)) {
            System.out.println("Invalid input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }
    public static String validateInput(String input, NumberSystem type) {
        if (type == NumberSystem.Binary) {
            while (input == null || !input.matches("[0-1]+")) {
                System.out.println("The number need to contain 0 and 1 only.");
                System.out.print(">>> ");
                input = scanner.nextLine();
            }
        } else {
            while (input == null || !input.matches("[A-F0-9]+")) {
                System.out.println("The number need to contain 0-9 and A-F only.");
                System.out.print(">>> ");
                input = scanner.nextLine();
            }
        }
        return input;
    }

    public static String[] splitCalculation(String calculation) {
        String mathOperations = "+-*/";
        String[] parseInp = new String[3];
        parseInp[0] = "";
        parseInp[1] = "unknown";
        parseInp[2] = "unknown";

        int index = 0;
        while (index < calculation.length() && mathOperations.indexOf(calculation.charAt(index)) < 0) {
            parseInp[0] += calculation.charAt(index);
            index++;
        }
        parseInp[0] = parseInp[0].trim();
        parseInp[1] = index < calculation.length() ? "" + calculation.charAt(index) : "unknown";
        parseInp[2] = calculation.length() > index + 1 ? calculation.substring(index + 1).trim() : "unknown";

        System.out.println(parseInp[0] + " " + parseInp[1] + " " + parseInp[2]);    // For debugging
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
