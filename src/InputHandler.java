import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    private InputHandler() {}

    public static String validateInput(String input, String regex) {
        while (!isGoodInput(input, regex)) {
            System.out.println("Invalid input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static boolean isGoodInput(String input, String regex) {
        return input != null && input.matches(regex);
    }

    public static String[] splitCalculation(String calculation) {
        String[] calcNumbers = calculation.split("[-+*/]");
        String[] parseInp = new String[3];

        if (calcNumbers.length == 2) {
            parseInp[0] = calcNumbers[0].trim();
            parseInp[1] = String.valueOf(calculation.charAt(calcNumbers[0].length()));
            parseInp[2] = calcNumbers[1].trim();
        }

        System.out.println(parseInp[0] + " " + parseInp[1] + " " + parseInp[2]);    // For debugging
        return parseInp;
    }

    public static void fileIO() {   // this works but how to make this better? and easier to look at lmao
        System.out.print("Enter path of your file: ");
        String path = scanner.nextLine();       // how to validate this?
        try {
            File file = new File(path);
            String fileName;
            Scanner readFile = new Scanner(file);
            String outPath;
            if (path.lastIndexOf("/") < 0 && path.lastIndexOf("\\") < 0) {
                fileName = path.substring(0 ,path.lastIndexOf(".txt"));
                outPath = fileName+"-output.txt";
            } else {
                fileName = path.substring(1 + path.lastIndexOf("/") + path.lastIndexOf("\\"),path.lastIndexOf(".txt"));
                int slashIndex = path.lastIndexOf("/") > 0 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1;
                outPath = path.substring(0, slashIndex)+fileName+"-output.txt";
            }

            File output = new File(outPath);
            PrintWriter printOutput = new PrintWriter(output);

            while (readFile.hasNextLine()) {        // file reading loop
                String line = readFile.nextLine();
                String[] lineArray = line.split(" ");

                int base;
                NumberSystem type;
                String out;
                switch (lineArray[0]) {     // 2 types Calculate or Convert
                    case "Calculate" -> {
                        if (lineArray[1].equals("Binary")) {
                            base = 2;
                            type = NumberSystem.Binary;
                        } else if (lineArray[1].equals("Hexadecimal")) {
                            base = 16;
                            type = NumberSystem.Hex;
                        } else {
                            printOutput.printf("%-43s>>> %s\n", line, "Error, invalid input.");
                            break;
                        }
                        String calcResult = BinaryHex.calculation(lineArray[3], lineArray[2], lineArray[4], base);
                        double calcResultDeci = BinaryHex.biHex2Decimal(calcResult, base);
                        double remainder = BinaryHex.biHex2Decimal(lineArray[3], base) % BinaryHex.biHex2Decimal(lineArray[4], base);
                        String numSysRemainder = BinaryHex.decimal2BiHex(remainder, base);
                        if (lineArray[2].equals("/")) {
                            out = String.format("%s result = %s, Remainder : %s    |   Decimal result = %.0f, Remainder : %.0f\n", // make print string method in binaryHex class
                                    type.toString(), calcResult, numSysRemainder, calcResultDeci, remainder);                   // improve this chunk of code some how
                        } else {
                            out = String.format("%s result = %s    |   Decimal result = %.0f\n",
                                    type.toString(), calcResult, calcResultDeci);
                        }
                        printOutput.printf("%-43s>>> %s", line, out);
                    }
                    case "Convert" -> {
                        String numSys = lineArray[4]; //input validate this
                        switch (lineArray[1]) {
                            case "Binary" -> out = String.format("Decimal value: %.0f\n", BinaryHex.biHex2Decimal(numSys, 2));
                            case "Hexadecimal" -> out = String.format("Decimal value: %.0f\n", BinaryHex.biHex2Decimal(numSys, 16));
                            case "Decimal" -> {
                                double decimal = Double.parseDouble(lineArray[4]);
                                if (lineArray[3].equals("Binary")) {
                                    base = 2;
                                } else {
                                    base = 16;
                                }
                                out = String.format("%s value: %s\n", "Hex", BinaryHex.decimal2BiHex(decimal, base));
                            }
                            default -> out = "Error, invalid input.\n";
                        }

                        printOutput.printf("%-43s>>> %s", line, out);
                    }
                    default -> printOutput.printf("%s-43s>>> Error, invalid input.\n", line);   // if first word not Calculate or convert print error
                }

            }
            printOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }
    }
}