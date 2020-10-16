import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    private InputHandler() {}

    public static String validateInput(String input, String regex) {
        while (!isGoodInput(input, regex)) {
            System.out.println("\033[31mInvalid\033[0m input, please try again:");
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
                    default -> printOutput.printf("%s      (#_#) Error, invalid input.\n", line);   // if first word not Calculate or convert print error
                }
            }
            System.out.println("\033[96;1mOutput generated successfully.\033[0m");
            printOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }
    }

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
                String fileSize = input[4].substring(0, 1).matches("[KMGT]") ? input[3] + " " + input[4].charAt(0) + "B" : input[3] + " B";
                out = Bandwidth.DownUpTime(fileSize, input[5] + input[6]) + "\n";
            }
            case "Website" -> {
                double[] webBW = Bandwidth.webBandwidth(input[3] + " " + input[4] + " " + input[5],
                        input[7].substring(0, 1).matches("[KMGT]") ? input[6] + " " + input[7].charAt(0) + "B" : input[6] + " B");
                String firstPart = String.format("Bandwidth needed: %f Mbits/s or %f GB/month",webBW[0], webBW[1]);
                String secondPart = String.format("With redundancy of %s: %f Mbits/s or %f GB/month",input[8], webBW[0] * Double.parseDouble(input[8]), webBW[1] * Double.parseDouble(input[8]));
                out = String.format("%-70s    |   %s\n", firstPart, secondPart);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }

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
                double data = Double.parseDouble(input[5]); // always b or bit
                String convertToUnit;
                if (input[4].substring(0, 1).matches("[KMGT]")) convertToUnit = input[4].charAt(0) + "B";
                else if (input[4].substring(0, 1).matches("[kmgt]")) convertToUnit = input[4].charAt(0) + "b";
                else convertToUnit = input[4].charAt(0) + "";
                out = String.format("%s bits is equivalent to %f %s\n", input[5], data*Bandwidth.unitConvert("b", convertToUnit), convertToUnit);
            }
            case "Monthly" -> {
                double usageAmount = Double.parseDouble(input[5]);
                String usageUnit = input[6].substring(0, 1).matches("[KMGT]") ? input[6].charAt(0) + "B" : "B";
                String bwUnit = input[8];
                out = String.format("%.2f %s per month is equivalent to %f %s\n", usageAmount, usageUnit,
                        usageAmount*Bandwidth.unitConvert(usageUnit, input[8].substring(0, input[8].lastIndexOf("b")+1).toLowerCase())/2629800, bwUnit);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }
}