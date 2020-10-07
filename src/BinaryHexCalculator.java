import java.util.Scanner;

public class BinaryHexCalculator {

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final String numberSystem;
    private final int base;

    public BinaryHexCalculator(int usrChoice) {     // implement a way to read calculations from text file
        if (usrChoice == 1) {                       // computes and output results to a text file
            this.numberSystem = "Binary";
            this.base = 2;
        }
        else {
            this.numberSystem = "Hex";
            this.base = 16;
        }
        selectOperation();
    }

    private void selectOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Select which %s operation to perform: \n", this.numberSystem);
        System.out.printf("1. %s Calculation\n", this.numberSystem);
        System.out.printf("2. %s to decimal\n", this.numberSystem);
        System.out.printf("3. Decimal to %s\n", this.numberSystem);
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = input == null || !input.matches("[0-9]+") ? 0 : Integer.parseInt(input);

        switch (choice) {
            case 1 -> calculation();
            case 2 -> {
                System.out.printf("Input %s: ", this.numberSystem);
                String inp = scanner.nextLine().toUpperCase();
                String num;
                if (this.numberSystem.equals("Binary") && !inp.matches("[0-1]+")) {
                    System.out.println("The number need to contain 0 and 1 only.");
                    break;
                }
                else if (this.numberSystem.equals("Hex") && !inp.matches("[A-F0-9]+")) {
                    System.out.println("The number need to contain 0-9 and A-F only.");
                    break;
                }
                else
                    num = inp;

                System.out.printf("Decimal value: %d\n", (long)numberSystemToDecimal(num, this.base));
            }
            case 3 -> {
                System.out.print("Input decimal: ");
                String inp = scanner.nextLine();
                double decimal;
                if (inp == null || !inp.matches("[0-9]+")) {
                    System.out.println("The number need to contain 0-9 only.");
                    break;
                } else
                    decimal = Double.parseDouble(inp);

                System.out.printf("%s value: %s\n", this.numberSystem, decimalToNumberSystem(decimal, this.base));
            }
            default -> System.out.println("Not an available option.");
        }
    }

    private void calculation() {    // uses lots of conversion (4 times), can we do both hex and binary calculations without converting???
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s calculation: ", this.numberSystem);
        String input = scanner.nextLine().toUpperCase();
        String calculation;
        if (!input.matches("^[-+*/A-Z0-9\\s]+")) {
            System.out.println("Invalid Input.");
        } else {
            calculation = input;
            String[] parseInp = Utilities.parseOperation(calculation);
            String firstVar = parseInp[0];
            String operator = parseInp[1];
            String secondVar = parseInp[2];

            double firstDeci = numberSystemToDecimal(firstVar, this.base);
            double secondDeci = numberSystemToDecimal(secondVar, this.base);
            double resultDeci = 0;
            String resultBinary;
            switch (operator) {
                case "+" -> resultDeci = firstDeci + secondDeci;
                case "-" -> resultDeci = firstDeci - secondDeci;
                case "*" -> resultDeci = firstDeci * secondDeci;
                case "/" -> resultDeci = firstDeci / secondDeci;
                default -> System.out.println("Error");
            }
            resultBinary = decimalToNumberSystem(resultDeci, this.base);

            if (operator.equals("/")) {
                double remainder = firstDeci % secondDeci;
                String binaryRemainder = decimalToNumberSystem(remainder, this.base);
                System.out.printf("Binary result = %s    Remainder : %s\n", resultBinary, binaryRemainder);
                System.out.printf("Decimal result = %.0f    Remainder : %.0f", resultDeci, remainder);
            } else {
                System.out.printf("Binary result = %s\n", resultBinary);
                System.out.printf("Decimal result = %.0f\n", resultDeci);
            }
        }
    }

    public static double numberSystemToDecimal(String num, int base) {
        double decimal = 0.0;
        int currentPow = num.length()-1;
        for (int i = 0; i < num.length(); i++, currentPow--) {
            decimal += Character.getNumericValue(num.charAt(i)) * Utilities.power(base, currentPow);
        }
        return decimal;
    }

    public static String decimalToNumberSystem(double decimalDouble, int base) {
        StringBuilder binary = new StringBuilder();
        long decimal = (long)decimalDouble;
        if (decimal == 0)
            return "0";
        else if (decimal < 0)
            binary.insert(0,"-");

        while (decimal != 0) {
            binary.insert(0,HEX_VALUES.charAt((int)Utilities.absolute(decimal) % base));
            decimal /= base;
        }
        return binary.toString();
    }
}