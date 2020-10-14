import java.util.Scanner;

public class BinaryHexCalculator {

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final Scanner scanner = new Scanner(System.in);
    private final NumberSystem type;
    private final int base;

    public BinaryHexCalculator(int usrChoice) {     // implement a way to read calculations from text file
        if (usrChoice == 1) {                       // computes and output results to a text file
            this.type = NumberSystem.Binary;
            this.base = 2;
        }
        else {
            this.type =  NumberSystem.Hex;
            this.base = 16;
        }
        selectOperation();
    }

    private void selectOperation() {
        System.out.printf("Select which %s operation to perform: \n", this.type.toString());
        System.out.printf("1: %s calculation\n", this.type.toString());
        System.out.printf("2: %s to decimal\n", this.type.toString());
        System.out.printf("3: Decimal to %s\n", this.type.toString());
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(Ult.validateInput(input, "[1-3]+"));

        switch (choice) {
            case 1 -> {
                System.out.printf("Input %s calculation: ", this.type.toString());
                input = scanner.nextLine().toUpperCase();
                String calculation;
                if (this.type == NumberSystem.Binary) {
                    calculation = Ult.validateInput(input, "[-+*/0-1\\s]+");
                } else {
                    calculation = Ult.validateInput(input, "[-+*/A-F0-9\\s]+");
                }
                String[] parseInp = Ult.splitCalculation(calculation);

                while (parseInp[0] == null) {                                                  // How can we shorten this input validation?
                    System.out.println("Please input valid calculation.");
                    System.out.print(">>> ");
                    input = scanner.nextLine().toUpperCase();
                    if (this.type == NumberSystem.Binary) {
                        calculation = Ult.validateInput(input, "[-+*/0-1\\s]+");
                    } else {
                        calculation = Ult.validateInput(input, "[-+*/A-F0-9\\s]+");
                    }
                    parseInp = Ult.splitCalculation(calculation);
                }
                String result = calculation(parseInp[0], parseInp[1], parseInp[2], this.base);
                double resultDeci = numberSystemToDecimal(result, this.base);

                if (parseInp[1].equals("/")) {
                    double remainder = numberSystemToDecimal(parseInp[0], this.base) % numberSystemToDecimal(parseInp[2], this.base);
                    String binaryRemainder = decimalToNumberSystem(remainder, base);
                    System.out.printf("%s result = %s    Remainder : %s\n", this.type.toString(), result, binaryRemainder);
                    System.out.printf("Decimal result = %.0f    Remainder : %.0f", Math.floor(resultDeci), remainder);
                } else {
                    System.out.printf("%s result = %s\n", this.type.toString(), result);
                    System.out.printf("Decimal result = %.0f\n", resultDeci);
                }
            }
            case 2 -> {
                System.out.printf("Input %s: ", this.type.toString());
                String inp = scanner.nextLine().toUpperCase();
                String num = Ult.validateInput(inp, this.type);
                System.out.printf("Decimal value: %.0f\n", numberSystemToDecimal(num, this.base));
            }
            case 3 -> {
                System.out.print("Input decimal: ");
                String inp = scanner.nextLine();
                double decimal = Double.parseDouble(Ult.validateInput(inp.substring(0, 15), "[-0-9]+"));        // is it a good idea to only take 16 digits like calculator.net?
                System.out.printf("%s value: %s\n", this.type.toString(), decimalToNumberSystem(decimal, this.base));   // can we do better?
            }
            default -> System.out.println("Error: " + choice);
        }
    }

    public static String calculation(String var1, String op, String var2, int base) {    // uses lots of conversion (4 times), can we do both hex and binary calculations without converting???
        double firstDeci = numberSystemToDecimal(var1, base);
        double secondDeci = numberSystemToDecimal(var2, base);
        double resultDeci = 0;
        switch (op) {
            case "+" -> resultDeci = firstDeci + secondDeci;
            case "-" -> resultDeci = firstDeci - secondDeci;
            case "*" -> resultDeci = firstDeci * secondDeci;
            case "/" -> resultDeci = firstDeci / secondDeci;
            default -> System.out.printf("Error: %f %s %f\n", firstDeci, op, secondDeci);
        }
        return decimalToNumberSystem(resultDeci, base);
    }

    public static double numberSystemToDecimal(String num, int base) {
        double decimal = 0.0;
        int currentPow = num.length()-1;
        for (int i = 0; i < num.length(); i++, currentPow--) {
            decimal += Character.getNumericValue(num.charAt(i)) * Math.pow(base, currentPow);
        }
        return decimal;
    }

    public static String decimalToNumberSystem(double decimalDouble, int base) {
        StringBuilder binary = new StringBuilder();
        long decimal = (long) decimalDouble;     // could this introduce overflow???
        if (decimal == 0)
            return "0";

        while (decimal != 0) {
            double index = Math.abs(decimal) % base;
            binary.insert(0,HEX_VALUES.charAt((int) index));
            decimal /= base;
        }
        if (decimalDouble < 0)
            binary.insert(0, '-');
        return binary.toString();
    }
}