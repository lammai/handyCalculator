import java.util.Scanner;

public class Ult {

    private static final Scanner scanner = new Scanner(System.in);

    private Ult() {}

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
