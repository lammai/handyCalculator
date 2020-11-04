package Controller;

import Model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import static View.BinHexCLI.performCalculation;
import static View.HandyCalculator.isBadInput;

/**
 * This class responsible for handling the file reading and writing.
 */
public class FileIO {

    private final String inputPath;
    private final String outputPath;

    /**
     * The constructor take in the path for the input text file,
     * as well as the path of the output file, and set them up accordingly.
     * @param inputPath The path of the input file.
     * @param outputPath The path of the output file.
     */
    public FileIO(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    /**
     * This method read the input text file line by line,
     * check if the text file is in the correct format, then perform
     * calculations/conversions. The result will be written in a new
     * text file placed in the same directory as the input file.
     */
    public void processFile() {
        try {
            File inputFile = new File(inputPath);
            Scanner scanFile = new Scanner(inputFile);

            File output = new File(outputPath);
            PrintWriter printOutput = new PrintWriter(output);

            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                String[] lineToken = line.split(" ");

                String out;
                switch (lineToken[0]) {     // 2 types of operation: Calculate or Convert
                    case "Calculate" -> {
                        out = handleCalculate(lineToken);
                        printOutput.printf("%-69s>>> %s", line, out);
                    }
                    case "Convert" -> {
                        out = handleConvert(lineToken);
                        printOutput.printf("%-69s>>> %s", line, out);
                    } // if first word not Calculate or Convert print error
                    default -> printOutput.printf("%s      (#_#) Error, invalid input.\n", line);
                }
            }
            printOutput.close();
            System.out.println("Output generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
    }

    private String handleCalculate(String[] input) {
        String out;
        try {
            switch (input[1]) {
                case "Binary" -> {
                    if (isBadInput(input[3], "[0-1]+") || isBadInput(input[2], "[-+*/]") || isBadInput(input[4], "[0-1]+"))
                        throw new IllegalArgumentException();
                    String[] result = performCalculation(new Binary(input[3]), input[2], input[4]);
                    out = String.format("%-34s    |   %s\n", result[0], result[1]);
                }
                case "Hexadecimal" -> {
                    if (isBadInput(input[3], "[a-fA-F0-9]+") || isBadInput(input[2], "[-+*/]") || isBadInput(input[4], "[a-fA-F0-9]+"))
                        throw new IllegalArgumentException();
                    String[] result = performCalculation(new Hex(input[3]), input[2], input[4]);
                    out = String.format("%-34s    |   %s\n", result[0], result[1]);
                }
                case "Download/Upload" -> {
                    if (!input[2].equals("Time") || isBadInput(input[3], "[0-9]+")
                            || isBadInput(input[4], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b") || isBadInput(input[5], "[0-1]+")
                            || isBadInput(input[6], "[KMGT]?bit/s"))
                        throw new IllegalArgumentException();

                    String[] result = new DownloadUploadCalculator(new SizeUnit(input[3],
                            SizeUnit.Size.valueOfLabel(input[4].substring(0, 1).matches("[KMGT]") ? input[4].charAt(0) + "B" : "B")),
                            new RateUnit(input[5], RateUnit.Rate.valueOfLabel(input[6]))).calculate();
                    out = String.format("Time needed: %s\n", Arrays.toString(result));
                }
                case "Website" -> {
                    if (!input[2].equals("Bandwidth") || isBadInput(input[3], "[0-9]+") || !input[4].equals("per")
                            || isBadInput(input[5], "\\b(second|minute|hour|day|week|month|year|Second|Minute|Hour|Day|Week|Month|Year)\\b")
                            || isBadInput(input[6], "[0-9]+") || isBadInput(input[7], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b")
                            || isBadInput(input[8], "[0-9]+"))
                        throw new IllegalArgumentException();

                    String[] results = new WebsiteBandwidthCalculator(new TimeUnit(input[3], TimeUnit.Time.valueOfLabel(input[5].toLowerCase())), // Adjust Size unit to be in the form
                            new SizeUnit(input[6], SizeUnit.Size.valueOfLabel(input[7].substring(0, 1).matches("[KMGT]") ? input[7].charAt(0) + "B" : "B")),
                            Double.parseDouble(input[8])).calculate();                                                                           // B to TB instead of Bytes to Terabytes
                    String firstPart = String.format("Bandwidth needed: %s or %s", results[0], results[1]);
                    String secondPart = String.format("With redundancy of %s: %s or %s", input[8], results[2], results[3]);
                    out = String.format("%-82s    |   %s\n", firstPart, secondPart);
                }
                default -> out = "Error, invalid input.\n";
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            out = "Error, invalid input.\n";
        }
        return out;
    }

    private String handleConvert(String[] input) {
        String out;
        try {
            switch (input[1]) {
                case "Binary" -> {
                    if (!input[2].equals("to") || !input[3].equals("Decimal") || isBadInput(input[4], "[0-9]+"))
                        throw new IllegalArgumentException();
                    out = String.format("Decimal value: %.0f\n", new BigDecimal(new BinaryCalculator(new Binary(input[4])).convertToDec().getValue()));
                }
                case "Hexadecimal" -> {
                    if (!input[2].equals("to") || !input[3].equals("Decimal") || isBadInput(input[4], "[0-9]+"))
                        throw new IllegalArgumentException();
                    out = String.format("Decimal value: %.0f\n", new BigDecimal(new HexCalculator(new Hex(input[4])).convertToDec().getValue()));
                }
                case "Decimal" -> {
                    if (!input[2].equals("to") || isBadInput(input[3], "\\b(Binary|Hexadecimal)\\b") || isBadInput(input[4], "[0-9]+"))
                        throw new IllegalArgumentException();
                    if (input[3].equals("Binary"))
                        out = String.format("Binary value: %s\n", new DecimalCalculator(new Decimal(input[4])).convertToBin().getValue());
                    else
                        out = String.format("Hexadecimal value: %s\n", new DecimalCalculator(new Decimal(input[4])).convertToHex().getValue());
                }
                case "Data" -> {
                    if (!input[2].equals("Unit") || !input[3].equals("to")
                            || isBadInput(input[4], "\\b(bits|kilobits|megabits|gigabits|terabits|Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b")
                            || isBadInput(input[5], "[0-9]+"))
                        throw new IllegalArgumentException();

                    String convertToUnit;
                    if (input[4].substring(0, 1).matches("[KMGT]")) convertToUnit = input[4].charAt(0) + "B";
                    else if (input[4].substring(0, 1).matches("[kmgt]")) convertToUnit = input[4].charAt(0) + "b";
                    else convertToUnit = input[4].charAt(0) + "";
                    String convertResult = "" + Double.parseDouble(new SizeUnit(input[5], SizeUnit.Size.BITS).getValue())
                            * (SizeUnit.Size.BITS.toBits / SizeUnit.Size.valueOfLabel(convertToUnit).toBits);
                    out = String.format("%s bits is equivalent to %s %s\n", input[5],
                            convertResult,
                            SizeUnit.Size.valueOfLabel(convertToUnit).label);
                }
                case "Monthly" -> {
                    if (!input[2].equals("Usage") || !input[3].equals("to") || !input[4].equals("Bandwidth") || isBadInput(input[5], "[0-9]+")
                            || isBadInput(input[6], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b") || isBadInput(input[7], "[0-9]+")
                            || isBadInput(input[8], "[KMGT]?bit/s"))
                        throw new IllegalArgumentException();

                    String usageUnit = input[6].substring(0, 1).matches("[KMGT]") ? input[6].charAt(0) + "B" : "B";
                    String result1 = new HostingBandwidthCalculator(new SizeUnit(input[5], SizeUnit.Size.valueOfLabel(usageUnit)), RateUnit.Rate.valueOfLabel(input[8])).convert();
                    String month2Sec = String.format("%s %s per month is equivalent to %s", input[5], input[6], result1);

                    String result2 = new HostingBandwidthCalculator(new RateUnit(input[7], RateUnit.Rate.valueOfLabel(input[8])), SizeUnit.Size.valueOfLabel(usageUnit)).convert();
                    String sec2Month = String.format("%s %s is equivalent to %s", input[7], input[8], result2);

                    out = String.format("%-60s    |   %s\n", month2Sec, sec2Month);
                }
                default -> out = "Error, invalid input.\n";
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            out = "Error, invalid input.\n";
        }
        return out;
    }
}