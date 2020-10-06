import java.util.Scanner;

public class BinaryHexCalculator {

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final String numberSystem;
    private final int base;

    public BinaryHexCalculator(int usrChoice) {
        if (usrChoice == 1) {
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
        System.out.printf("Select which %s operation to perform: \n", numberSystem);
        System.out.printf("1. %s Calculation\n", numberSystem);
        System.out.printf("2. %s to decimal\n", numberSystem);
        System.out.printf("3. Decimal to %s\n", numberSystem);
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = input == null || !input.matches("[0-9]+") ? 0 : Integer.parseInt(input);

        switch (choice) {
            case 1 -> calculation();
            case 2 -> {
                System.out.printf("Input %s: ", numberSystem);
                String inp = scanner.nextLine().toUpperCase();
                String num;
                if (numberSystem.equals("Binary") && !inp.matches("[0-1]+")) {
                    System.out.println("The number need to contain 0 and 1 only.");
                    break;
                }
                else if (numberSystem.equals("Hex") && !inp.matches("[A-F0-9]+")) {
                    System.out.println("The number need to contain 0-9 and A-F only.");
                    break;
                }
                else
                    num = inp;

                System.out.printf("Decimal value: %d\n", (long)numberSystemToDecimal(num));
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

                System.out.printf("%s value: %s\n", numberSystem, decimalToNumberSystem(decimal));
            }
            default -> System.out.println("Not an available option.");
        }
    }

    private void calculation() {    // uses lots of conversion (4 times), can we do both hex and binary calculations without converting???
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s calculation: ", numberSystem);
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

            double firstDeci = numberSystemToDecimal(firstVar);
            double secondDeci = numberSystemToDecimal(secondVar);
            double resultDeci = 0;
            String resultBinary;
            switch (operator) {
                case "+" -> resultDeci = firstDeci + secondDeci;
                case "-" -> resultDeci = firstDeci - secondDeci;
                case "*" -> resultDeci = firstDeci * secondDeci;
                case "/" -> resultDeci = firstDeci / secondDeci;
                default -> System.out.println("Error");
            }
            resultBinary = decimalToNumberSystem(resultDeci);

            if (operator.equals("/")) {
                double remainder = firstDeci % secondDeci;
                String binaryRemainder = decimalToNumberSystem(remainder);
                System.out.printf("Binary result = %s    Remainder : %s\n", resultBinary, binaryRemainder);
                System.out.printf("Decimal result = %.0f    Remainder : %.0f", resultDeci, remainder);
            } else {
                System.out.printf("Binary result = %s\n", resultBinary);
                System.out.printf("Decimal result = %.0f\n", resultDeci);
            }
        }
    }

    public double numberSystemToDecimal(String num) {
        double decimal = 0.0;
        int currentPow = num.length()-1;
        for (int i = 0; i < num.length(); i++, currentPow--) {
            decimal += Character.getNumericValue(num.charAt(i)) * Utilities.power(this.base, currentPow);
        }
        return decimal;
    }
    public String decimalToNumberSystem(double decimalDouble) {
        StringBuilder binary = new StringBuilder();
        long decimal = (long)decimalDouble;
        if (decimal == 0)
            return "0";
        else if (decimal < 0)
            binary.insert(0,"-");

        while (decimal != 0) {
            binary.insert(0,HEX_VALUES.charAt((int)Utilities.absolute(decimal) % this.base));
            decimal /= this.base;
        }
        return binary.toString();
    }
}