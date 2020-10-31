import java.util.Scanner;

/**
 * The BinaryHex class handle the conversions and calculations related to Binary and Hexadecimal numbers.
 */
public class BinaryHex {

    private static final String HEX_VALUES = "0123456789ABCDEF";
    private final Scanner scanner = new Scanner(System.in);
    private final NumberSystem type;
    private final int base;

    /**
     * This constructor set the base value correspond to the type of number system
     * and promt the user for the next set of inputs.
     * @param aType Determine the type of numbers system.
     */
    public BinaryHex(NumberSystem aType) {
        this.type = aType;
        if (this.type == NumberSystem.Binary) this.base = 2;
        else this.base = 16;

        selectOperation();
    }

    private void selectOperation() {
        System.out.printf("\n\n\033[1;4mSelect which %s operation to perform: \033[0m\n", this.type.toString());
        System.out.printf("\033[91m1\033[0m: %s calculation\n", this.type.toString());
        System.out.printf("\033[91m2\033[0m: %s to decimal\n", this.type.toString());
        System.out.printf("\033[91m3\033[0m: Decimal to %s\n", this.type.toString());
        System.out.print(">>> ");

        String input = scanner.nextLine();  // Regular expressions are use across the program to validate input.
        int choice = Integer.parseInt(InputHandler.validateInput(input, "[1-3]+"));

        if (choice == 1) {      // Calculation
            System.out.printf("Input %s calculation [var1] [operator] [var2]: ", this.type.toString());
            input = scanner.nextLine().toUpperCase();
            String calculation;
            String regex;
            if (this.type == NumberSystem.Binary)
                regex = "[-+*/0-1\\s]+";
            else
                regex = "[-+*/A-F0-9\\s]+";
            calculation = InputHandler.validateInput(input, regex);
            String[] parseInp = InputHandler.splitCalculation(calculation);

            while (parseInp[0] == null) {   // calculation input validation loop
                System.out.println("\033[31mPlease input valid calculation.\033[0m");
                System.out.print(">>> ");
                input = scanner.nextLine().toUpperCase();
                calculation = InputHandler.validateInput(input, regex);
                parseInp = InputHandler.splitCalculation(calculation);
            }
            String[] print = calcToString(parseInp, this.type, this.base);
            System.out.print("\033[96;1m"+print[0] + "\n" + print[1] + "\033[0m\n");

        } else if (choice == 2) {   // Binary/Hex to Decimal conversions
            System.out.printf("Input %s: ", this.type.toString());
            String inp = scanner.nextLine().toUpperCase();
            String num;
            if (this.type == NumberSystem.Binary)
                num = InputHandler.validateInput(inp, "[0-1]+");
            else
                num = InputHandler.validateInput(inp, "[A-F0-9]+");
            System.out.printf("Decimal value: \033[96;1m%.0f\033[0m\n", biHex2Decimal(num, this.base));
        } else {            // Decimal to Binary/Hex conversions
            System.out.print("Input decimal: ");
            String inp = scanner.nextLine();
            String decimal = InputHandler.validateInput(inp, "[-]?[0-9]+");
            System.out.printf("%s value: \033[96;1m%s\033[0m\n", this.type.toString(), decimal2BiHex(Double.parseDouble(decimal), this.base));
        }
    }

    /**
     * This method construct a readable string with the calculation results in order to display it nicely for the user.
     * @param input The number variables and operator of a calculation.
     * @param type The type of number system.
     * @param base The base of number system.
     * @return a string array for result in the number system and in decimal.
     */
    public static String[] calcToString(String[] input, NumberSystem type, int base) {
        String result = calculation(input[0], input[1], input[2], base);
        double resultDeci = biHex2Decimal(result, base);
        String[] out = new String[2];
        if (input[1].equals("/")) {
            double remainder = biHex2Decimal(input[0], base) % biHex2Decimal(input[2], base);
            String numSysRemainder = decimal2BiHex(remainder, base);
            out[0] = String.format("%s result = %s    Remainder : %s", type.toString(), result, numSysRemainder);
            out[1] = String.format("Decimal result = %.0f    Remainder : %.0f", Math.floor(resultDeci), remainder);
        } else {
            out[0] = String.format("%s result = %s", type.toString(), result);
            out[1] = String.format("Decimal result = %.0f", resultDeci);
        }
        return out;
    }

    /**
     * This method calculation and return the result for Binary or Hex. Featuring four basic operations:
     * addition, subtraction, multiplication, division.
     * @param var1 The first variable in the calculation.
     * @param op The operator in the calculation.
     * @param var2 The second variable in the calculation.
     * @param base The base of the number system.
     * @return The result of the calculation in Binary or Hex.
     */
    public static String calculation(String var1, String op, String var2, int base) {
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

    /**
     * This method convert a Binary or Hex number into decimal.
     * @param num The Binary or Hexadecimal number to be converted.
     * @param base The base correspond to the number system.
     * @return The converted decimal value.
     */
    public static double biHex2Decimal(String num, int base) {
        double decimal = 0.0;
        int currentPow = num.length()-1;
        System.out.println(base);
        for (int i = 0; i < num.length(); i++, currentPow--) {
            decimal += Character.getNumericValue(num.charAt(i)) * Math.pow(base, currentPow);
        }
        return decimal;
    }

    /**
     * This method convert a decimal number into Binary or Hex.
     * @param decimalDouble The decimal number to be converted.
     * @param base The base of the number system to be convert to.
     * @return The Binary or Hex value.
     */
    public static String decimal2BiHex(double decimalDouble, int base) {
        StringBuilder binary = new StringBuilder();
        long decimal = (long)decimalDouble;
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