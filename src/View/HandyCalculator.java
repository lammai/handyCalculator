package View;

import java.util.Scanner;

import static View.BandwidthCLI.handleBandwidth;
import static View.BinHexCLI.handleBinHex;

public class HandyCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input;
        System.out.println("\033[1;4mPlease select from the following options: \033[0m");
        System.out.println("\033[91m1\033[0m: Binary Calculator");
        System.out.println("\033[91m2\033[0m: Hex Calculator");
        System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
        System.out.println("\033[91m4\033[0m: Input data file");
        System.out.println("\033[91mq\033[0m: Quit");
        do {
            System.out.print("\n\033[31;1;3mMain Menu Selection >>> \033[0m");
            input = scanner.nextLine();
            String userChoice = validateInput(input, "[1-4q]");

            System.out.println("\033[96m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\033[0m");
            switch (userChoice) {
                case "1" -> handleBinHex(NumberSystem.Binary);
                case "2" -> handleBinHex(NumberSystem.Hex);
                case "3" -> handleBandwidth();
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
}
