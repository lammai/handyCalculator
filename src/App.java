import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("**********Calculator**********");
        System.out.println("Please select from the following options: ");
        System.out.println("1. Binary Calculator");
        System.out.println("2. Hex Calculator");
        System.out.println("3. IP Subnet Calculator");
        System.out.println("4. Bandwidth Calculator");
        System.out.print(">>> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int userChoice = input == null || !input.matches("[0-9]+") ? 0 : Integer.parseInt(input);

        while (userChoice < 1 || userChoice > 4) {
            System.out.println("Invalid input, Please try again: ");
            System.out.print(">>> ");
            input = scanner.nextLine();
            userChoice = input == null || !input.matches("[0-9]+") ? 0 : Integer.parseInt(input);
        }

        System.out.println("********************************");
        if (userChoice == 1 || userChoice == 2) {
            new BinaryHexCalculator(userChoice);
        }
    }
}
