import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("**********Calculator**********");           // add more eye candy ascii
        System.out.println("Please select from the following options: ");
        System.out.println("1: Binary Calculator");
        System.out.println("2: Hex Calculator");
        System.out.println("3: Bandwidth Calculator");
        System.out.println("4: Input data file");
        System.out.print(">>> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int userChoice = Integer.parseInt(Ult.validateInput(input, "[1-4]+"));

        System.out.println("********************************");
        if (userChoice == 1) {
            new BinaryHex(NumberSystem.Binary);
        } else if (userChoice == 2) {
            new BinaryHex(NumberSystem.Hex);
        } else if (userChoice == 3){
            new Bandwidth();
        } else {
            outputFile();
        }
    }

    public static void outputFile() {   // this works but how to make this better? and easier to look at lmao
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path of your file: ");
        String path = scanner.nextLine();       // how to validate this?
        try {
            File file = new File(path);
            Scanner readFile = new Scanner(file);
            String outPath;
            if (path.lastIndexOf("/") < 0 && path.lastIndexOf("\\") < 0) {
                outPath = "output.txt";
            } else {
                int slashIndex = path.lastIndexOf("/") > 0 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1;
                outPath = path.substring(0, slashIndex)+"output.txt";
            }

            File output = new File(outPath);
            PrintWriter printOutput = new PrintWriter(output);

            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] lineArray = line.split(" ");

                int base;
                NumberSystem type;
                String out;
                switch (lineArray[0]) {
                    case "Calculate" -> {
                        if (lineArray[1].equals("Binary")) {
                            base = 2;
                            type = NumberSystem.Binary;
                        } else if (lineArray[1].equals("Hexadecimal")) {
                            type = NumberSystem.Hex;
                            base = 16;
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
                    default -> printOutput.printf("%s-43s>>> Error, invalid input.\n", line);
                }

            }
            printOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }
    }
}