package Controller;

import Model.Binary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {

    private String inputPath;
    private String outputPath;

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
        String out;
        String[] calcRearrange = {input[3], input[2], input[4]};
        switch (input[1]) {
            case "Binary" -> {
                Binary binary = new Binary(input[3]);
                String[] remainder;
                switch (input[2]) {
                    case "+" -> { new BinaryCalculator(binary).add(new Binary(input[4])); }     // working on generalizing outputs
                    case "-" -> { new BinaryCalculator(binary).subtract(new Binary(input[4])); }
                    case "*" -> { new BinaryCalculator(binary).multiply(new Binary(input[4])); }
                    case "/" -> { new BinaryCalculator(binary).divide(new Binary(input[4])); }
                    default -> out = "Error";
                }

                out = "";
            }
            default -> out = "Error, invalid input.\n";
        }
        return out;
    }

    private String handleConvert(String[] input) {
        return "";
    }
}
