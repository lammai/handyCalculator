import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("**********Calculator**********");           // add more eye candy ascii
        System.out.println("Please select from the following options: ");
        System.out.println("1: Binary Calculator");
        System.out.println("2: Hex Calculator");
        System.out.println("3: Bandwidth Calculator");
        System.out.println("4: Input data file");
        System.out.print(">>> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int userChoice = Integer.parseInt(InputHandler.validateInput(input, "[1-4]+"));

        System.out.println("********************************");
        if (userChoice == 1) new BinaryHex(NumberSystem.Binary);
        else if (userChoice == 2) new BinaryHex(NumberSystem.Hex);
        else if (userChoice == 3) new Bandwidth();
        else InputHandler.fileIO();
    }
}