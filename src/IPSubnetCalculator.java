import java.util.Map;
import java.util.Scanner;

public class IPSubnetCalculator {

    private final Scanner scanner = new Scanner(System.in);

    public IPSubnetCalculator() {
        selectIPV();
    }

    private void selectIPV() {
        System.out.println("Select:");
        System.out.println("1: IPV4");
        System.out.println("2: IPV6");
        System.out.print(">>> ");
        String input = scanner.nextLine();

        int userChoice = input == null || !input.matches("[1-2]+") ? 0 : Integer.parseInt(input);
        if (userChoice == 1) {
            IPV4calculator();
        } else if (userChoice == 2) {
            System.out.println("IPV6 in the work");
            //IPV6
        } else {
            System.out.println("Not an available option.");
        }
    }

    private void IPV4calculator() {
        System.out.println("Input network class (A, B, C, or Any):");
        System.out.print(">>> ");

        String input = scanner.nextLine().toUpperCase();
        String networkClass = !input.matches("[A-Z]+") ? "Unknown" : input; // what if they enter random string of letters

        Map<Integer, String> subnetMasks = Ult.generateNetMasks();      // make this class field? initialize using block???
        //Output table of subnet masks according to network class
        int trackColumn = 1;
        switch(networkClass) {
            case "ANY":
                for (int i = 1; i < 8; i++, trackColumn++) {
                    System.out.printf("%-6s","");
                    System.out.printf("%15s /%d", subnetMasks.get(i), i);
                    if (trackColumn % 3 == 0)
                        System.out.println();
                }
            case "A":
                for (int i = 8; i < 16; i++, trackColumn++) {
                    System.out.printf("%-6s","");
                    System.out.printf("%15s /%d", subnetMasks.get(i), i);
                    if (trackColumn % 3 == 0)
                        System.out.println();
                }
            case "B":
                for (int i = 16; i < 24; i++, trackColumn++) {
                    System.out.printf("%-6s","");
                    System.out.printf("%15s /%d", subnetMasks.get(i), i);
                    if (trackColumn % 3 == 0)
                        System.out.println();
                }
            case "C":
                for (int i = 24; i < 33; i++, trackColumn++) {
                    System.out.printf("%-6s","");
                    System.out.printf("%15s /%d", subnetMasks.get(i), i);
                    if (trackColumn % 3 == 0)
                        System.out.println();
                }
                break;
            default:
                System.out.println("Error: " + networkClass);
        }

        System.out.println("\nSelect subnet from the list above by entering prefix size (E.g. /30)");
        System.out.print(">>> ");
        input = scanner.nextLine();
        String prefixLength = input.length() > 3 || !input.matches("^[/0-9]+") ? "Unknown" : input; // how can we use this to access map items???

        System.out.print("Input IP address: ");
        input = scanner.nextLine();
        String ipAddress = !input.matches("^[.0-9]+") ? "Unknown" : input;      // better input validation all across the program??? keep asking til they get it right???

        // do calculation with IPV4
    }
}
