package View;

import Controller.BinaryCalculator;
import Model.Binary;

import java.util.Scanner;

public class handyCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input;
        do {
            System.out.println("\033[1;4mPlease select from the following options: \033[0m");
            System.out.println("\033[91m1\033[0m: Binary Calculator");
            System.out.println("\033[91m2\033[0m: Hex Calculator");
            System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
            System.out.println("\033[91m4\033[0m: Input data file");
            System.out.println("\033[91mq\033[0m: Quit");
            System.out.print("\033[31;1;3mMain Menu Selection >>> \033[0m");
            input = scanner.nextLine();
            String userChoice = validateInput(input, "[1-4q]");

            System.out.println("\033[96m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\033[0m");
            switch (userChoice) {
                case "1" -> {
                    handleBinHex("Binary");
                }
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
            }
        }while (!input.equals("q"));

    }

    /**
     * This method determine if an input is correct or not.
     * @param input The input to be check.
     * @param regex The regular expression to match the input with.
     * @return A truth value base on the given input.
     */
    public static boolean isGoodInput(String input, String regex) {
        return input != null && input.matches(regex);
    }

    /**
     * This method ask the user to provide the correct input before moving on.
     * @param input The input to be validated.
     * @param regex The regular expression to match the input with.
     * @return The validated input.
     */
    public static String validateInput(String input, String regex) {
        while (!isGoodInput(input, regex)) {
            System.out.println("\033[31mInvalid\033[0m input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }

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
            parseInp[2] = calcNumbers[1].trim();
        }

        return parseInp;
    }

    public static String[] performCalculation(Binary bin, String op, String var) {
        String[] remainder = new String[2];
        switch (op) {
            case "+" -> {new BinaryCalculator(bin).add(new Binary(var));}
            case "-" -> {new BinaryCalculator(bin).subtract(new Binary(var));}
            case "*" -> {new BinaryCalculator(bin).multiply(new Binary(var));}
            case "/" -> {remainder = new BinaryCalculator(bin).divide(new Binary(var));}
            default -> {}
        }
        return remainder;
    }

    private static void handleBinHex(String numType) {
        System.out.printf("\n\n\033[1;4mSelect which %s operation to perform: \033[0m\n", numType);
        System.out.printf("\033[91m1\033[0m: %s calculation\n", numType);
        System.out.printf("\033[91m2\033[0m: %s to decimal\n", numType);
        System.out.printf("\033[91m3\033[0m: Decimal to %s\n", numType);
        System.out.print(">>> ");

        String input = scanner.nextLine();  // Regular expressions are use across the program to validate input.
        int choice = Integer.parseInt(validateInput(input, "[1-3]+"));

        if (choice == 1) {      // Calculation
            System.out.printf("Input %s calculation [var1] [operator] [var2]: ", numType);
            input = scanner.nextLine().toUpperCase();
            String calculation;
            String regex;
            if (numType.equals("Binary"))
                regex = "[-+*/0-1\\s]+";
            else
                regex = "[-+*/A-F0-9\\s]+";
            calculation = validateInput(input, regex);
            String[] parseInp = splitCalculation(calculation);

            while (parseInp[0] == null || parseInp[1] == null || parseInp[2] == null) {   // calculation input validation loop
                System.out.println("\033[31mPlease input valid calculation.\033[0m");
                System.out.print(">>> ");
                input = scanner.nextLine().toUpperCase();
                calculation = validateInput(input, regex);
                parseInp = splitCalculation(calculation);
            }
            Binary binary = new Binary(parseInp[0]);        // this method was meant to be generalize for both bi and hex
            String[] result = performCalculation(binary, parseInp[1], parseInp[2]); // this right now would only work for binary
            if (result[1] == null) {                                                // How can we make it work for both???
                System.out.println("Binary value: " + binary.getValue());
                System.out.println("Decimal value: " + new BinaryCalculator(binary).convertToDec().getValue());
            } else {
                System.out.printf("Binary value: %s    Remainder: %s\n", binary.getValue(), result[1]);
                System.out.printf("Decimal value: %s    Remainder: %s\n", new BinaryCalculator(binary).convertToDec().getValue(), result[0]);
            }

//            System.out.print("\033[96;1m"+print[0] + "\n" + print[1] + "\033[0m\n");
//
//        } else if (choice == 2) {   // Binary/Hex to Decimal conversions
//            System.out.printf("Input %s: ", this.type.toString());
//            String inp = scanner.nextLine().toUpperCase();
//            String num;
//            if (this.type == NumberSystem.Binary)
//                num = validateInput(inp, "[0-1]+");
//            else
//                num = validateInput(inp, "[A-F0-9]+");
//            System.out.printf("Decimal value: \033[96;1m%.0f\033[0m\n", biHex2Decimal(num, this.base));
//        } else {            // Decimal to Binary/Hex conversions
//            System.out.print("Input decimal: ");
//            String inp = scanner.nextLine();
//            String decimal = validateInput(inp, "[-]?[0-9]+");
//            System.out.printf("%s value: \033[96;1m%s\033[0m\n", this.type.toString(), decimal2BiHex(Double.parseDouble(decimal), this.base));
        }
    }
}
