package Controller;

import Model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import static View.BinHexCLI.performCalculation;
import static View.HandyCalculator.isGoodInput;

public class FileIO {

    private final String inputPath;
    private final String outputPath;

    public FileIO(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

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
        String out = "";
        switch (input[1]) {
            case "Binary" -> {
                if (!isGoodInput(input[3], "[0-1]+") || !isGoodInput(input[2], "[-+*/]") || !isGoodInput(input[4], "[0-1]+"))
                    break;
                String[] result = performCalculation(new Binary(input[3]), input[2], input[4]);
                out = String.format("%-34s    |   %s\n", result[0], result[1]);
            }
            case "Hexadecimal" -> {
                if (!isGoodInput(input[3], "[a-fA-F0-9]+") || !isGoodInput(input[2], "[-+*/]") || !isGoodInput(input[4], "[a-fA-F0-9]+"))
                    break;
                String[] result = performCalculation(new Hex(input[3]), input[2], input[4]);
                out = String.format("%-34s    |   %s\n", result[0], result[1]);
            }
            case "Download/Upload" -> {
                if (!input[2].equals("Time") || !isGoodInput(input[3], "[0-9]+")
                        || !isGoodInput(input[4], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b") || !isGoodInput(input[5], "[0-1]+")
                        || !isGoodInput(input[6], "[KMGT]?bit/s"))
                    break;
                String[] result = new DownloadUploadCalculator(new Decimal(input[3]),
                        SizeUnit.Size.valueOfLabel(input[4].substring(0, 1).matches("[KMGT]") ? input[4].charAt(0) + "B" : "B"),
                        new Decimal(input[5]), RateUnit.Rate.valueOfLabel(input[6])).calculate();
                out = String.format("Time needed: %s\n", Arrays.toString(result));
            }
            case "Website" -> {
                if (!input[2].equals("Bandwidth") || !isGoodInput(input[3], "[0-9]+") || !input[4].equals("per")
                        || !isGoodInput(input[5], "\\b(second|minute|hour|day|week|month|year|Second|Minute|Hour|Day|Week|Month|Year)\\b")
                        || !isGoodInput(input[6], "[0-9]+") || !isGoodInput(input[7], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b")
                        || !isGoodInput(input[8], "[0-9]+"))
                    break;
                String[] result = new WebsiteBandwidthCalculator(new Decimal(input[3]), TimeUnit.Time.valueOfLabel(input[5].toLowerCase()),
                        new Decimal(input[6]),                                      // Adjust Size unit to be in the form
                        SizeUnit.Size.valueOfLabel(input[7].substring(0, 1).matches("[KMGT]") ? input[7].charAt(0) + "B" : "B"),
                        Double.parseDouble(input[8])).calculate();                  // B to TB instead of Bytes to Terabytes
                String firstPart = String.format("Bandwidth needed: %s or %s",result[0], result[1]);
                String secondPart = String.format("With redundancy of %s: %s or %s", input[8], result[2], result[3]);
                out = String.format("%-82s    |   %s\n", firstPart, secondPart);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }

    private String handleConvert(String[] input) {
        String out = "";
        switch (input[1]) {
            case "Binary" -> {
                if (!input[2].equals("to") || !input[3].equals("Decimal") || !isGoodInput(input[4], "[0-9]+"))
                    break;
                out = String.format("Decimal value: %.0f\n", new BigDecimal(new BinaryCalculator(new Binary(input[4])).convertToDec().getValue()));
            }
            case "Hexadecimal" -> {
                if (!input[2].equals("to") || !input[3].equals("Decimal") || !isGoodInput(input[4], "[0-9]+"))
                    break;
                out = String.format("Decimal value: %.0f\n", new BigDecimal(new HexCalculator(new Hex(input[4])).convertToDec().getValue()));
            }
            case "Decimal" -> {
                if (!input[2].equals("to") || !isGoodInput(input[3], "\\b(Binary|Hexadecimal)\\b") || !isGoodInput(input[4], "[0-9]+"))
                    break;
                if (input[3].equals("Binary"))
                    out = String.format("Binary value: %s\n", new DecimalCalculator(new Decimal(input[4])).convertToBin().getValue());
                else
                    out = String.format("Hexadecimal value: %s\n", new DecimalCalculator(new Decimal(input[4])).convertToHex().getValue());
            }
            case "Data" -> {
                if (!input[2].equals("Unit") || !input[3].equals("to")
                        || !isGoodInput(input[4], "\\b(bits|kilobits|megabits|gigabits|terabits|Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b")
                        || !isGoodInput(input[5], "[0-9]+"))
                    break;

                String convertToUnit;
                if (input[4].substring(0, 1).matches("[KMGT]")) convertToUnit = input[4].charAt(0) + "B";
                else if (input[4].substring(0, 1).matches("[kmgt]")) convertToUnit = input[4].charAt(0) + "b";
                else convertToUnit = input[4].charAt(0) + "";
                String convertResult = ""+Double.parseDouble(new SizeUnit(input[5], SizeUnit.Size.BITS).getValue()) * (SizeUnit.Size.BITS.toBits / SizeUnit.Size.valueOfLabel(convertToUnit).toBits);
                out = String.format("%s bits is equivalent to %s %s\n", input[5],
                        convertResult,
                        SizeUnit.Size.valueOfLabel(convertToUnit).label);
            }
            case "Monthly" -> {
                if (!input[2].equals("Usage") || !input[3].equals("to") || !input[4].equals("Bandwidth") || !isGoodInput(input[5], "[0-9]+")
                        || !isGoodInput(input[6], "\\b(Bytes|Kilobytes|Megabytes|Gigabytes|Terabytes)\\b") || !isGoodInput(input[7], "[0-9]+")
                        || !isGoodInput(input[8], "[KMGT]?bit/s"))
                    break;

                String usageUnit = input[6].substring(0, 1).matches("[KMGT]") ? input[6].charAt(0) + "B" : "B";
                String result1 = new HostingBandwidthCalculator(new Decimal(input[5]), SizeUnit.Size.valueOfLabel(usageUnit), RateUnit.Rate.valueOfLabel(input[8])).convert();
                String month2Sec = String.format("%s %s per month is equivalent to %s", input[5], input[6], result1);

                String result2 = new HostingBandwidthCalculator(new Decimal(input[7]), RateUnit.Rate.valueOfLabel(input[8]), SizeUnit.Size.valueOfLabel(usageUnit)).convert();
                String sec2Month = String.format("%s %s is equivalent to %s", input[7], input[8], result2);

                out = String.format("%-60s    |   %s\n", month2Sec, sec2Month);
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }
}