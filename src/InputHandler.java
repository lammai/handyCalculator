import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class provides important methods to validate user inputs across the entire program.
 * It handle the file input and output operation.
 */
public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Default empty constructor does nothing
     */
    public InputHandler() {}

    /**
     * This method ask the user to provide the correct input before moving on.
     * @param input The input to be validated.
     * @param regex The regular expression to match the input with.
     * @return The validated input.
     */
    public static String validateInput(String input, String regex) {
        while (!isGoodInput(input, regex)) {
            System.out.println("\033[31mInvalid\033[0m input, please try again:");
            System.out.print(">>> ");
            input = scanner.nextLine();
        }
        return input;
    }

    /**
     * This method determine if an input is correct or not.
     * @param input The input to be check.
     * @param regex The regular expression to match the input with.
     * @return A truth value base on the given input.
     */
    public static boolean isGoodInput(String input, String regex) {
        return input != null && input.matches(regex);
    }

    /**
     * This method split a calculation input into the correct token to be use by calculation methods.
     * @param calculation The validated calculation input.
     * @return An array of two variables and an operator.
     */
    public static String[] splitCalculation(String calculation) {
        String[] calcNumbers = calculation.split("[-+*/]");
        String[] parseInp = new String[3];

        if (calcNumbers.length == 2) {
            parseInp[0] = calcNumbers[0].trim();
            parseInp[1] = String.valueOf(calculation.charAt(calcNumbers[0].length()));
            parseInp[2] = calcNumbers[1].trim();
        }

        return parseInp;
    }

    /**
     * This method handle the reading of the text file input and give an output will answers to the calculations
     * in the same folder as the input file.
     */
    public static void fileIO() {
        System.out.print("Enter path of your file: ");
        String path = scanner.nextLine();
        try {
            File file = new File(path);
            String fileName;
            Scanner readFile = new Scanner(file);
            String outPath;
            // Figure out the name of the input txt file.
            if (path.lastIndexOf("/") < 0 && path.lastIndexOf("\\") < 0) {
                fileName = path.substring(0 ,path.lastIndexOf(".txt"));
                outPath = fileName+"-output.txt";
            } else {
                // Give the output the original input name with output.txt at the end
                fileName = path.substring(1 + path.lastIndexOf("/") + path.lastIndexOf("\\"),path.lastIndexOf(".txt"));
                int slashIndex = path.lastIndexOf("/") > 0 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1;
                outPath = path.substring(0, slashIndex)+fileName+"-output.txt";
            }

            File output = new File(outPath);
            PrintWriter printOutput = new PrintWriter(output);      // create output file and write to it

            while (readFile.hasNextLine()) {        // file reading loop
                String line = readFile.nextLine();
                String[] lineArray = line.split(" ");

                String out;
                switch (lineArray[0]) {     // 2 types Calculate or Convert
                    case "Calculate" -> {
                        out = handleCalculate(lineArray);
                        printOutput.printf("%-69s>>> %s", line, out);
                    }
                    case "Convert" -> {
                        out = handleConvert(lineArray);
                        printOutput.printf("%-69s>>> %s", line, out);
                    }
                    default -> printOutput.printf("%s      (#_#) Error, invalid input.\n", line);   // if first word not Calculate or Convert print error
                }
            }
            System.out.println("\033[96;1mOutput generated successfully.\033[0m");
            printOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }
    }

    /**
     * This method calculate and format the result nicely to be printed in the text file.
     * @param input The tokenized line of the input.
     * @return The formatted string that display the calculation result.
     */
    private static String handleCalculate(String[] input) {
        String out;
        String[] calcRearrange = {input[3], input[2], input[4]};
        switch (input[1]) {
            case "Binary" -> {
                String[] result = BinaryHex.calcToString(calcRearrange, NumberSystem.Binary, 2);
                out = String.format("%-34s    |   %s\n", result[0], result[1]);
            }
            case "Hexadecimal" -> {
                String[] result = BinaryHex.calcToString(calcRearrange, NumberSystem.Hex, 16);
                out = String.format("%-34s    |   %s\n", result[0], result[1]);
            }
            case "Download/Upload" -> {
                String fileSize = input[4].substring(0, 1).matches("[KMGT]") ?
                        input[3] + " " + input[4].charAt(0) + "B" : input[3] + " B";
                out = Bandwidth.DownUpTime(fileSize, input[5] + input[6]) + "\n";
            }
            case "Website" -> {
                double[] webBW = Bandwidth.webBandwidth(input[3] + " " + input[4] + " " + input[5],
                        input[7].substring(0, 1).matches("[KMGT]") ? input[6] + " " + input[7].charAt(0) + "B" : input[6] + " B");
                String firstPart = String.format("Bandwidth needed: %f Mbits/s or %f GB/month",webBW[0], webBW[1]);
                String secondPart = String.format("With redundancy of %s: %f Mbits/s or %f GB/month",input[8], webBW[0]
                        * Double.parseDouble(input[8]), webBW[1] * Double.parseDouble(input[8]));
                out = String.format("%-70s    |   %s\n", firstPart, secondPart);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }

    /**
     * This method convert and format the conversion according to the corresponding operation.
     * @param input The tokenized line of the input.
     * @return The formatted string that display the conversion result.
     */
    private static String handleConvert(String[] input) {
        String out;
        switch (input[1]) {
            case "Binary" -> out = String.format("Decimal value: %.0f\n", BinaryHex.biHex2Decimal(input[4], 2));
            case "Hexadecimal" -> out = String.format("Decimal value: %.0f\n", BinaryHex.biHex2Decimal(input[4], 16));
            case "Decimal" -> {
                int base;
                if (input[3].equals("Binary")) base = 2;
                else base = 16;
                out = String.format("%s value: %s\n", input[3], BinaryHex.decimal2BiHex(Double.parseDouble(input[4]), base));
            }
            case "Data" -> {
                double data = Double.parseDouble(input[5]);
                String convertToUnit;
                if (input[4].substring(0, 1).matches("[KMGT]")) convertToUnit = input[4].charAt(0) + "B";
                else if (input[4].substring(0, 1).matches("[kmgt]")) convertToUnit = input[4].charAt(0) + "b";
                else convertToUnit = input[4].charAt(0) + "";
                out = String.format("%s bits is equivalent to %f %s\n", input[5], data*Bandwidth.unitConvert("b", convertToUnit), convertToUnit);
            }
            case "Monthly" -> {
                double usageAmountMonth = Double.parseDouble(input[5]);
                String usageUnitMonth = input[6].substring(0, 1).matches("[KMGT]") ? input[6].charAt(0) + "B" : "B";
                double usageAmountBand = Double.parseDouble(input[7]);
                String bwUnit = input[8].substring(0, input[8].lastIndexOf("b")+1).toLowerCase();
                String month2Sec = String.format("%.2f %s per month is equivalent to %f %s per second",
                        usageAmountMonth, usageUnitMonth, usageAmountMonth*Bandwidth.unitConvert(usageUnitMonth, bwUnit)/2629800, bwUnit);
                String sec2Month = String.format("%.2f %s per second is equivalent to %f %s per month", usageAmountBand, bwUnit,
                        usageAmountBand*Bandwidth.unitConvert(bwUnit, usageUnitMonth)*2629800, usageUnitMonth);
                out = String.format("%-60s    |   %s\n", month2Sec, sec2Month);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }
}