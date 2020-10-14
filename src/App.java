import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        int userChoice = Integer.parseInt(Ult.validateInput(input, "[1-4]+"));

        System.out.println("********************************");
        if (userChoice == 1 || userChoice == 2) {
            new BinaryHexCalculator(userChoice);
        } else if (userChoice == 3){
            // Bandwidth here
        } else {
            System.out.print("Enter path of your file: ");
            String path = scanner.nextLine();       // how to validate this?
            try {
                File file = new File(path);
                Scanner readFile = new Scanner(file);
                while (readFile.hasNextLine()) {
                    String line = readFile.nextLine();
                    String[] lineArray = line.split(" ");
                    int base;
                    switch (lineArray[0]) {
                        case "Calculate":
                            if (lineArray[1].equals("Binary")) {
                                base = 2;
                            } else {
                                base = 16;
                            }
                            System.out.println(BinaryHexCalculator.calculation(lineArray[3], lineArray[2], lineArray[4], base));
                            break;
                        case "Convert":
                            if (lineArray[1].equals("Binary")) {
                                System.out.println(BinaryHexCalculator.numberSystemToDecimal(lineArray[4], 2));
                            } else if (lineArray[1].equals("Hexadecimal")) {
                                System.out.println(BinaryHexCalculator.numberSystemToDecimal(lineArray[4], 16));
                            } else {
                                if (lineArray[3].equals("Binary")) {
                                    base = 2;
                                } else {
                                    base = 16;
                                }
                                System.out.println(BinaryHexCalculator.decimalToNumberSystem(Double.parseDouble(lineArray[4]), base));
                            }
                            break;
                        default:
                            System.out.println("Error");
                            System.out.println(Arrays.toString(lineArray));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error, file not found.");
            }

        }
    }


}
