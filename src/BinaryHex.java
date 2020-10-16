import java.util.Scanner;

public class BinaryHex {

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final Scanner scanner = new Scanner(System.in);
    private final NumberSystem type;
    private final int base;

    public BinaryHex(NumberSystem aType) {     // implement a way to read calculations from text file
        this.type = aType;
        if (this.type == NumberSystem.Binary) this.base = 2;               // computes and output results to a text file
        else this.base = 16;

        selectOperation();
    }

    public void selectOperation() {
        System.out.printf("Select which %s operation to perform: \n", this.type.toString());
        System.out.printf("1: %s calculation\n", this.type.toString());
        System.out.printf("2: %s to decimal\n", this.type.toString());
        System.out.printf("3: Decimal to %s\n", this.type.toString());
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(InputHandler.validateInput(input, "[1-3]+"));

        if (choice == 1) {
            System.out.printf("Input %s calculation: ", this.type.toString());
            input = scanner.nextLine().toUpperCase();
            String calculation;
            String regex;
            if (this.type == NumberSystem.Binary)
                regex = "[-+*/0-1\\s]+";
            else
                regex = "[-+*/A-F0-9\\s]+";
            calculation = InputHandler.validateInput(input, regex);
            String[] parseInp = InputHandler.splitCalculation(calculation);

            while (parseInp[0] == null) {         // How can we shorten this input validation?
                System.out.println("Please input valid calculation.");
                System.out.print(">>> ");
                input = scanner.nextLine().toUpperCase();
                calculation = InputHandler.validateInput(input, regex);
                parseInp = InputHandler.splitCalculation(calculation);
            }
            String result = calculation(parseInp[0], parseInp[1], parseInp[2], this.base);
            double resultDeci = biHex2Decimal(result, this.base);

            if (parseInp[1].equals("/")) {
                double remainder = biHex2Decimal(parseInp[0], this.base) % biHex2Decimal(parseInp[2], this.base);
                String numSysRemainder = decimal2BiHex(remainder, base);
                System.out.printf("%s result = %s    Remainder : %s\n", this.type.toString(), result, numSysRemainder);
                System.out.printf("Decimal result = %.0f    Remainder : %.0f", Math.floor(resultDeci), remainder);
            } else {
                System.out.printf("%s result = %s\n", this.type.toString(), result);
                System.out.printf("Decimal result = %.0f\n", resultDeci);
            }
        } else if (choice == 2) {
            System.out.printf("Input %s: ", this.type.toString());
            String inp = scanner.nextLine().toUpperCase();
            String num;
            if (this.type == NumberSystem.Binary)
                num = InputHandler.validateInput(inp, "[0-1]+");
            else
                num = InputHandler.validateInput(inp, "[A-F0-9]+");
            System.out.printf("Decimal value: %.0f\n", biHex2Decimal(num, this.base));
        } else {
            System.out.print("Input decimal: ");
            String inp = scanner.nextLine();
            double decimal = Double.parseDouble(InputHandler.validateInput(inp, "[-0-9]+"));        // is it a good idea to only take 16 digits like calculator.net?
            System.out.printf("%s value: %s\n", this.type.toString(), decimal2BiHex(decimal, this.base));   // can we do better?
        }
    }

    public static String calculation(String var1, String op, String var2, int base) {    // uses lots of conversion (4 times), can we do both hex and binary calculations without converting???
        double firstDeci = biHex2Decimal(var1, base);
        double secondDeci = biHex2Decimal(var2, base);
        double resultDeci = 0;
        switch (op) {
            case "+" -> resultDeci = firstDeci + secondDeci;
            case "-" -> resultDeci = firstDeci - secondDeci;
            case "*" -> resultDeci = firstDeci * secondDeci;
            case "/" -> resultDeci = firstDeci / secondDeci;
            default -> System.out.printf("Error: %f %s %f\n", firstDeci, op, secondDeci);
        }
        return decimal2BiHex(resultDeci, base);
    }

    public static double biHex2Decimal(String num, int base) {
        double decimal = 0.0;
        int currentPow = num.length()-1;
        for (int i = 0; i < num.length(); i++, currentPow--) {
            decimal += Character.getNumericValue(num.charAt(i)) * Math.pow(base, currentPow);
        }
        return decimal;
    }

    public static String decimal2BiHex(double decimalDouble, int base) {
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