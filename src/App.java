import java.util.Scanner;

/**
 * This Calculator program support Binary and Hexadecimal conversions as well as basic calculations.
 * It includes a Bandwidth calculator that features data unit conversions and other bandwidth related utilities.
 * It also enable the user to get output of multiple calculations by providing a text file.
 *
 * @author Lam Mai
 * @version 1.0
 * @since 10-16-2020
 */
public class App {

    /**
     * The main method serves as the main menu for the calculator, direct the user's choice to the corresponding
     * calculator.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("\033[96m█▀▀ ▄▀█ █░░ █▀▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█");
        System.out.println("\033[96m█▄▄ █▀█ █▄▄ █▄▄ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄\033[0m");

        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("\033[1;4mPlease select from the following options: \033[0m");
        System.out.println("\033[91m1\033[0m: Binary Calculator");
        System.out.println("\033[91m2\033[0m: Hex Calculator");
        System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
        System.out.println("\033[91m4\033[0m: Input data file");
        System.out.println("\033[91mq\033[0m: Quit");
        do {
            System.out.print("\033[31;1;3mMain Menu Selection >>> \033[0m");
            input = scanner.nextLine();
            String userChoice = InputHandler.validateInput(input, "[1-4q]");

            System.out.println("\033[96m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\033[0m");
            switch (userChoice) {
                case "1" -> new BinaryHex(NumberSystem.Binary);
                case "2" -> new BinaryHex(NumberSystem.Hex);
                case "3" -> new Bandwidth();
                case "4" -> InputHandler.fileIO();
            }
        }while (!input.equals("q"));
    }
}