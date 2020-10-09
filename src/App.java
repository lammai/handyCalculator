import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("**********Calculator**********");
        System.out.println("Please select from the following options: ");
        System.out.println("1: Binary Calculator");
        System.out.println("2: Hex Calculator");
        System.out.println("3: IP Subnet Calculator");
        System.out.println("4: Bandwidth Calculator");
        System.out.print(">>> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int userChoice = Integer.parseInt(Ult.validateInput(input, "[1-4]+"));

        System.out.println("********************************");
        if (userChoice == 1 || userChoice == 2) {
            new BinaryHexCalculator(userChoice);
        } else if (userChoice == 3) {
            new IPSubnetCalculator();
        }
    }
}
