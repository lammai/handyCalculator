import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\033[31m█▀▀ ▄▀█ █░░ █▀▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█");           // add more eye candy ascii
        System.out.println("\033[31m█▄▄ █▀█ █▄▄ █▄▄ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄\033[0m");
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("\n\n\033[1;4mPlease select from the following options: \033[0m");
        System.out.println("\033[91m1\033[0m: Binary Calculator");
        System.out.println("\033[91m2\033[0m: Hex Calculator");
        System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
        System.out.println("\033[91m4\033[0m: Input data file");
        System.out.println("\033[91mq\033[0m: quit");
        do {
            System.out.print("\033[31;1;3mMain Menu Selection >>> \033[0m");
            input = scanner.nextLine();
            String userChoice = InputHandler.validateInput(input, "[1-4q]");

            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            switch (userChoice) {
                case "1" -> new BinaryHex(NumberSystem.Binary);
                case "2" -> new BinaryHex(NumberSystem.Hex);
                case "3" -> new Bandwidth();
                case "4" -> InputHandler.fileIO();
            }
        }while (!input.equals("q"));
    }
}