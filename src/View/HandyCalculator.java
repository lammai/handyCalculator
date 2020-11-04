package View;

import Controller.FileIO;
import Model.SizeUnit;

import java.util.Scanner;
import static View.BandwidthCLI.handleBandwidth;
import static View.BinHexCLI.handleBinHex;

/**
 * This Calculator program support Binary and Hexadecimal conversions as well as basic calculations.
 * It includes a Bandwidth calculator that features data unit conversions and other bandwidth related utilities.
 * It also enable the user to get output of multiple calculations by providing a text file.
 *
 * @author Lam Mai
 * @version 2.0
 * @since 11-1-2020
 */
public class HandyCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\033[96m<---------Handy Calculator--------->\033[0m");
        String input;
        String userChoice;
        displayMainMenu();
        do {
            System.out.print("\n\033[31;1;3mMain Menu Selection\n (Press h to display menu) >>> \033[0m");
            input = scanner.nextLine();
            userChoice = validateInput(input, "[1-4QHqh]").toLowerCase();

            System.out.println("\033[96m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\033[0m");
            switch (userChoice) {
                case "1" -> handleBinHex(NumberSystem.Binary);
                case "2" -> handleBinHex(NumberSystem.Hex);
                case "3" -> handleBandwidth();
                case "4" -> {
                    System.out.print("Enter path of your file: ");
                    String path = scanner.nextLine();
                    String outPath;
                    String fileName;
                    if (path.lastIndexOf("/") < 0 && path.lastIndexOf("\\") < 0) {
                        fileName = path.substring(0 ,path.lastIndexOf(".txt"));
                        outPath = fileName+"-output.txt";
                    } else {
                        // Give the output the original input name with output.txt at the end
                        fileName = path.substring(1 + path.lastIndexOf("/") + path.lastIndexOf("\\"),path.lastIndexOf(".txt"));
                        int slashIndex = path.lastIndexOf("/") > 0 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1;
                        outPath = path.substring(0, slashIndex)+fileName+"-output.txt";
                    }
                    FileIO fileIO = new FileIO(path, outPath);
                    fileIO.processFile();
                }
                case "h" -> displayMainMenu();
            }
        }while (!userChoice.equals("q"));

    }

    /**
     * This method determine if an input is correct or not.
     * @param input The input to be check.
     * @param regex The regular expression to match the input with.
     * @return A truth value base on the given input.
     */
    public static boolean isBadInput(String input, String regex) {
        return (input==null || !input.matches(regex));
    }

    /**
     * This method ask the user to provide the correct input before moving on.
     * @param input The input to be validated.
     * @param regex The regular expression to match the input with.
     * @return The validated input.
     */
    public static String validateInput(String input, String regex) {
        while (isBadInput(input, regex)) {
            System.out.println("\033[31mInvalid\033[0m input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }

    private static void displayMainMenu() {
        System.out.println("\033[1;4mPlease select from the following options: \033[0m");
        System.out.println("\033[91m1\033[0m: Binary Calculator");
        System.out.println("\033[91m2\033[0m: Hex Calculator");
        System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
        System.out.println("\033[91m4\033[0m: Input data file");
        System.out.println("\033[91mq\033[0m: Quit");
    }
}
