package View;

import Controller.DownloadUploadCalculator;
import Controller.HostingBandwidthCalculator;
import Controller.WebsiteBandwidthCalculator;
import Model.Decimal;
import Model.RateUnit;
import Model.SizeUnit;
import Model.TimeUnit;
import java.util.Arrays;
import java.util.Scanner;

import static View.HandyCalculator.validateInput;

public class BandwidthCLI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void handleBandwidth() {
        System.out.println("\n\n\033[1;4mSelect which Bandwidth calculation to perform:\033[0m");
        System.out.println("\033[91m1\033[0m. Data unit converter:");
        System.out.println("\033[91m2\033[0m. Download/Upload time calculator:");
        System.out.println("\033[91m3\033[0m. Website bandwidth calculator:");
        System.out.println("\033[91m4\033[0m. Hosting bandwidth calculator:");
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(validateInput(input, "[1-4]+"));

        if (choice == 1) {  // Data Unit conversion
            System.out.print("Input data size and unit(b-TB): ");
            input = scanner.nextLine().trim();                              //Using regular expression to validate input
            String validatedInput = validateInput(input, "[0-9]+[\\s]?[kmgtKMGT]?[bB]");

            SizeUnit.Size inputUnit = SizeUnit.Size.valueOfLabel(validatedInput.substring(validatedInput.length()-2));
            SizeUnit size = new SizeUnit(validatedInput.substring(0, validatedInput.length()-2).trim(), inputUnit);

            System.out.printf("%s is equivalent to any of the following:\n", validatedInput);
            SizeUnit.Size[] units = SizeUnit.Size.values();
            for (SizeUnit.Size unit : units) {         // Convert one data unit to every other data units.
                if (unit != size.getUnit()) {
                    String result = String.format("%f", Double.parseDouble(size.getValue()) * (size.getUnitInBits() / unit.toBits));
                    result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result; // Remove 0s trails
                    System.out.printf("\033[96;1m%s %s\033[0m\n", result, unit.toString().toLowerCase());
                }
            }

        } else if (choice == 2) {   // Download/Upload Time
            System.out.print("Input file size and unit(B-TB): ");
            input = scanner.nextLine();
            String sizeInput = validateInput(input, "\\d+(?:\\.\\d+)?[\\s]?[KMGT]?B");
            String fileSize = sizeInput.substring(0, sizeInput.length()-2);
            String sizeUnit = sizeInput.substring(sizeInput.length()-2);

            System.out.print("Input bandwidth and unit(bit/s - Tbit/s): ");
            input = scanner.nextLine();
            String bandwidthInput = validateInput(input, "\\d+(?:\\.\\d+)?[\\s]?[KMGT]?bit/s");
            int lastIndexBW = bandwidthInput.matches("\\d+(?:\\.\\d+)?[\\s]?[KMGT]bit/s") ?
                    bandwidthInput.lastIndexOf("b") - 1 : bandwidthInput.lastIndexOf("b");
            String bandwidth = bandwidthInput.substring(0, lastIndexBW);
            String unitBW = bandwidthInput.substring(lastIndexBW);

            DownloadUploadCalculator downUpCalc = new DownloadUploadCalculator(new Decimal(fileSize), SizeUnit.Size.valueOfLabel(sizeUnit),
                                                    new Decimal(bandwidth), RateUnit.Rate.valueOfLabel(unitBW));

            String[] results = downUpCalc.calculate();
            System.out.println("\033[96;1mDownload or upload time needed is: "+Arrays.toString(results)+"\033[0m");

        } else if (choice == 3) {   // Website Bandwidth
            System.out.print("Input page views ([quantity] per [time unit]): ");
            input = scanner.nextLine();
            String pgViews = validateInput(input, "\\d+(?:\\.\\d+)?[\\s]per[\\s]\\b(second|minute|hour|day|week|month|year|Second|Minute|Hour|Day|Week|Month|Year)\\b");
            String[] viewToken = pgViews.split(" ");

            System.out.print("Input average page size ([quantity] [data unit(B - TB)]): ");
            input = scanner.nextLine();
            String pgSize = validateInput(input, "\\d+(?:\\.\\d+)?[\\s][KMGT]?B");
            String[] sizeToken = pgSize.split(" ");

            System.out.print("Input redundancy factor: ");
            input = scanner.nextLine();
            double redunFactor = Double.parseDouble(validateInput(input, "\\d+(?:\\.\\d+)?"));

            WebsiteBandwidthCalculator webCalc = new WebsiteBandwidthCalculator(new Decimal(viewToken[0]), TimeUnit.Time.valueOfLabel(viewToken[2].toLowerCase()),
                                                new Decimal(sizeToken[0]), SizeUnit.Size.valueOfLabel(sizeToken[1]), redunFactor);

            String[] result = webCalc.calculate();

            System.out.printf("Actual bandwidth needed is \033[96;1m%s \033[0m or \033[96;1m%s\033[0m\n", result[0], result[1]);
            System.out.printf("With redundancy factor of \033[96;1m%.2f\033[0m, the bandwidth needed is: \033[96;1m%s \033[0m or \033[96;1m%s\033[0m\n",
                    redunFactor, result[2], result[3]);

        } else {    // Hosting Bandwidth
            String monthlyUnit = "[data unit(B - TB)]";
            String bandUnit = "[bandwidth unit(bit/s - Tbit/s)]";                   // Implemented the ability to determine:
            System.out.printf("Input monthly usage ([quantity] %s)\n",monthlyUnit); // If the user entered B-TB, then they want to convert Monthly usage to Bandwidth
            System.out.printf("OR Input bandwidth  ([quantity] %s)\n",bandUnit);    // If the user entered bit/s to Tbit/s, then convert Bandwidth to Monthly usage
            System.out.print(">>> ");
            input = scanner.nextLine();
            String usage;
            String convertTo;
            if (input.matches("\\d+(?:\\.\\d+)?[\\s][KMGT]?B")) {       // Using regex to determine B-TB
                usage = validateInput(input.toUpperCase(), "\\d+(?:\\.\\d+)?[\\s][KMGT]?B");
                convertTo = bandUnit;
            } else {
                usage = validateInput(input, "\\d+(?:\\.\\d+)?[\\s][KMGT]?bit/s");
                convertTo = monthlyUnit;
            }
            String[] usageToken = usage.split(" ");

            System.out.printf("Convert to? %s: ", convertTo);
            input = scanner.nextLine();

            String unit = input.matches("[KMGT]?B") ?              // If input is in B-TB validate that
                    validateInput(input, "[KMGT]?B") :             // else validate bit/s to Tbit/s and convert it to b-tb.
                    validateInput(input, "[KMGT]?bit/s");

            HostingBandwidthCalculator hostCalc;
            if (convertTo.equals(bandUnit)) {
                hostCalc = new HostingBandwidthCalculator(new Decimal(usageToken[0]), SizeUnit.Size.valueOfLabel(usageToken[1]), RateUnit.Rate.valueOfLabel(unit));
                usageToken[1] = usageToken[1] + " per month";
            } else {
                hostCalc = new HostingBandwidthCalculator(new Decimal(usageToken[0]), RateUnit.Rate.valueOfLabel(usageToken[1]), SizeUnit.Size.valueOfLabel(unit));
            }

            String result = hostCalc.convert();
            System.out.printf("\033[96;1m%s %s is equivalent to %s\033[0m\n", usageToken[0], usageToken[1], result);
        }
    }
}
