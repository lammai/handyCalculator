package View;

import Controller.BinaryCalculator;
import Controller.DecimalCalculator;
import Controller.HexCalculator;
import Model.Binary;
import Model.Decimal;
import Model.Hex;

import java.util.Arrays;
import java.util.Scanner;
import static View.HandyCalculator.validateInput;

/**
 * This class defines the CLI for both Binary and Hex operations.
 * It also contains methods useful for performing calculation in both CLI and text file environment.
 */
public class BinHexCLI {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This method split a calculation input into the correct token to be use by calculation methods.
     * @param calculation The validated calculation input.
     * @return An array of two variables and an operator.
     */
    public static String[] splitCalculation(String calculation) {
        String[] calcNumbers = calculation.split("[-+*/]");
        String[] parseInp = new String[3];

        if (calcNumbers.length == 2) {
            parseInp[0] = calcNumbers[0].trim();
            parseInp[1] = String.valueOf(calculation.charAt(calcNumbers[0].length()));
            parseInp[2] = calcNumbers[1].trim().matches("0+") && parseInp[1].equals("/") ? null : calcNumbers[1].trim();
        }

        return parseInp;
    }

    /**
     * This method determine the calculation operator from the user input
     * and perform the corresponding Binary calculation.
     * @param num The Binary number that represent the first variable.
     * @param op The calculation operator (+,-,*,/).
     * @param var The String value of the second variable.
     * @return A String array with results in both Binary and Decimal, as well as remainder if any.
     */
    public static String[] performCalculation(Binary num, String op, String var) {
        String[] results = new String[2];
        switch (op) {
            case "+" -> new BinaryCalculator(num).add(new Binary(var));
            case "-" -> new BinaryCalculator(num).subtract(new Binary(var));
            case "*" -> new BinaryCalculator(num).multiply(new Binary(var));
            case "/" -> results = new BinaryCalculator(num).divide(new Binary(var));
            default -> System.err.println("Calculation Error.");
        }
        if (results[0] == null) {
            return new String[]{ "Binary value: " + num.getValue(), String.format("Decimal value: %.0f", Double.parseDouble(new BinaryCalculator(num).toDecimal().getValue())) };
        }
        return new String[]{ String.format("Binary value: %s    Remainder: %s", num.getValue(), results[1]),
                String.format("Decimal value: %.0f    Remainder: %s", Double.parseDouble(new BinaryCalculator(num).toDecimal().getValue()), results[0])};
    }

    /**
     * This method determine the calculation operator from the user input
     * and perform the corresponding Hexadecimal calculation.
     * @param num The Hexadecimal number that represent the first variable.
     * @param op The calculation operator (+,-,*,/).
     * @param var The String value of the second variable.
     * @return A String array with results in both Hexadecimal and Decimal, as well as remainder if any.
     */
    public static String[] performCalculation(Hex num, String op, String var) {
        String[] remainder = new String[2];
        switch (op) {
            case "+" -> new HexCalculator(num).add(new Hex(var));
            case "-" -> new HexCalculator(num).subtract(new Hex(var));
            case "*" -> new HexCalculator(num).multiply(new Hex(var));
            case "/" -> remainder = new HexCalculator(num).divide(new Hex(var));
            default -> System.err.println("Calculation Error.");
        }
        if (remainder[0] == null) {
            return new String[]{ "Hex value: " + num.getValue(), String.format("Decimal value: %.0f", Double.parseDouble(new HexCalculator(num).toDecimal().getValue())) };
        }
        return new String[]{ String.format("Hex value: %s    Hex remainder: %s", num.getValue(), remainder[1]),
                String.format("Decimal value: %.0f    Decimal remainder: %s", Double.parseDouble(new HexCalculator(num).toDecimal().getValue()), remainder[0])};
    }

    /**
     * This method handle taking inputs from the user and displaying results for the corresponding
     * number system.
     * @param numType The type of number system (Binary or Hex).
     */
    public static void handleBinHex(NumberSystem numType) {
        System.out.printf("\n\n\033[1;4mSelect which %s operation to perform: \033[0m\n", numType.toString());
        System.out.printf("\033[91m1\033[0m: %s calculation\n", numType.toString());
        System.out.printf("\033[91m2\033[0m: %s to decimal\n", numType.toString());
        System.out.printf("\033[91m3\033[0m: Decimal to %s\n", numType.toString());
        System.out.print(">>> ");

        String input = scanner.nextLine();  // Regular expressions are use across the program to validate input.
        int choice = Integer.parseInt(validateInput(input, "[1-3]+"));

        if (choice == 1) {      // Calculation
            System.out.printf("Input %s calculation [var1] [operator] [var2]: ", numType.toString());
            input = scanner.nextLine().toUpperCase();
            String calculation;
            String regex = numType == NumberSystem.Binary ? "[-+*/0-1\\s]+" : "[-+*/A-F0-9\\s]+";

            calculation = validateInput(input, regex);
            String[] parseInp = splitCalculation(calculation);
            System.out.println(Arrays.toString(parseInp));
            while (parseInp[0] == null || parseInp[1] == null || parseInp[2] == null) {   // calculation input validation loop
                System.out.println("\033[31mPlease input valid calculation.\033[0m");
                System.out.print(">>> ");
                input = scanner.nextLine().toUpperCase();
                calculation = validateInput(input, regex);
                parseInp = splitCalculation(calculation);
            }

            String[] result;
            if (numType == NumberSystem.Binary) {
                Binary num = new Binary(parseInp[0]);
                result = performCalculation(num, parseInp[1], parseInp[2]);
            } else {
                Hex num = new Hex(parseInp[0]);
                result = performCalculation(num, parseInp[1], parseInp[2]);
            }
            System.out.printf("\033[96m%s\n%s\n\033[0m", result[0], result[1]);

        } else if (choice == 2) {   // Binary/Hex to Decimal conversions
            System.out.printf("Input %s: ", numType.toString());
            String inp = scanner.nextLine().toUpperCase();
            String regex = numType == NumberSystem.Binary ? "[-]?[0-1]+" : "[-]?[a-fA-F0-9]+";
            String num = validateInput(inp, regex);
            if (numType == NumberSystem.Binary)
                System.out.printf("Decimal value: \033[96;1m%s\033[0m\n", new BinaryCalculator(new Binary(num)).toDecimal().getValue());
            else
                System.out.printf("Decimal value: \033[96;1m%s\033[0m\n", new HexCalculator(new Hex(num)).toDecimal().getValue());

        } else {            // Decimal to Binary/Hex conversions
            System.out.print("Input decimal: ");
            String inp = scanner.nextLine();
            String decimal = validateInput(inp, "[-]?[0-9]+");
            if (numType == NumberSystem.Binary)
                System.out.printf("%s value: \033[96;1m%s\033[0m\n", numType.toString(), new DecimalCalculator(new Decimal(decimal)).toBinary().getValue());
            else
                System.out.printf("%s value: \033[96;1m%s\033[0m\n", numType.toString(), new DecimalCalculator(new Decimal(decimal)).toHex().getValue());

        }
    }
}
