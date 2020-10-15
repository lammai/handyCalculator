import java.util.Scanner;

public class Ult {

    private static final Scanner scanner = new Scanner(System.in);

    private Ult() {}

    public static String validateInput(String input, String regex) {
        while (!isGoodInput(input, regex)) {
            System.out.println("Invalid input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static boolean isGoodInput(String input, String regex) {
        return input != null && input.matches(regex);
    }

    public static String[] splitCalculation(String calculation) {
        String[] calcNumbers = calculation.split("[-+*/]");
        String[] parseInp = new String[3];

        if (calcNumbers.length == 2) {
            parseInp[0] = calcNumbers[0].trim();
            parseInp[1] = String.valueOf(calculation.charAt(calcNumbers[0].length()));
            parseInp[2] = calcNumbers[1].trim();
        }

        System.out.println(parseInp[0] + " " + parseInp[1] + " " + parseInp[2]);    // For debugging
        return parseInp;
    }
}