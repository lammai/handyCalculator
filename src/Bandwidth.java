import java.util.Scanner;

public class Bandwidth {
    private final Scanner scanner = new Scanner(System.in);
    private static final String[] units = {"b", "kb", "mb", "gb", "tb", "B", "KB", "MB", "GB", "TB"};

    private static final double KILOBITS_TO_BITS = 1e3,
                                MEGABITS_TO_BITS = 1e6,
                                GIGABITS_TO_BITS = 1e9,
                                TERABITS_TO_BITS = 1e12,
                                BYTES_TO_BITS = 8,
                                KILOBYTES_TO_BITS = 8e3,
                                MEGABYTES_TO_BITS = 8e6,
                                GIGABYTES_TO_BITS = 8e9,
                                TERABYTES_TO_BITS = 8e12;

    private static final double SECONDS_IN_YEAR = 3.15576e7,
                                SECONDS_IN_MONTH = 2629800,
                                SECONDS_IN_WEEK = 604800,
                                SECONDS_IN_DAY = 86400,
                                SECONDS_IN_HOUR = 3600,
                                SECONDS_IN_MINUTE = 60;

    public Bandwidth() {
        selectOperation();
    }

    private void selectOperation() {
        System.out.println("\n\n\033[1;4mSelect which Bandwidth calculation to perform:\033[0m");
        System.out.println("\033[91m1\033[0m. Data unit converter:");
        System.out.println("\033[91m2\033[0m. Download/Upload time calculator:");
        System.out.println("\033[91m3\033[0m. Website bandwidth calculator:");
        System.out.println("\033[91m4\033[0m. Hosting bandwidth calculator:");
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(InputHandler.validateInput(input, "[1-4]+"));

        if (choice == 1) {
            System.out.print("Input data size and unit(b-TB): ");
            input = scanner.nextLine().trim();
            String validatedInput = InputHandler.validateInput(input, "[0-9]+[\\s]?[kmgtKMGT]?[bB]");

            double dataSize = Double.parseDouble(validatedInput.substring(0, validatedInput.length()-2));
            String inpUnit = validatedInput.substring(validatedInput.length()-2);
            System.out.printf("%s is equivalent to any of the following:\n", validatedInput);
            for (String unit : units) {
                if (!unit.equals(inpUnit))
                    System.out.printf("\033[96;1m%f %s\033[0m\n", dataSize*unitConvert(inpUnit, unit), unit);
            }
        } else if (choice == 2) {
            System.out.print("Input file size and unit(B-TB): ");
            input = scanner.nextLine();
            String fileSize = InputHandler.validateInput(input, "\\d+(?:\\.\\d+)?[\\s]?[KMGT]?B");

            System.out.print("Input bandwidth and unit(bit/s - Tbit/s): ");
            input = scanner.nextLine();
            String bandwidth = InputHandler.validateInput(input, "\\d+(?:\\.\\d+)?[\\s]?[KMGT]?bit/s");

            System.out.println("\033[96;1m"+DownUpTime(fileSize, bandwidth)+"\033[0m");
        } else if (choice == 3) {
            System.out.print("Input page views ([quantity] per [time unit]): ");
            input = scanner.nextLine();
            String pgViews = InputHandler.validateInput(input, "\\d+(?:\\.\\d+)?[\\s]per[\\s][a-zA-Z]+");

            System.out.print("Input average page size ([quantity] [data unit(B - TB)]): ");
            input = scanner.nextLine();
            String pgSize = InputHandler.validateInput(input, "\\d+(?:\\.\\d+)?[\\s][KMGT]?B");

            System.out.print("Input redundancy factor: ");
            input = scanner.nextLine();
            double redunFactor = Double.parseDouble(InputHandler.validateInput(input, "\\d+(?:\\.\\d+)?"));

            double[] needBW = webBandwidth(pgViews.toLowerCase(), pgSize);
            System.out.printf("Actual bandwidth needed is \033[96;1m%f Mbits/s\033[0m or \033[96;1m%f GB/month\033[0m\n", needBW[0], needBW[1]);
            System.out.printf("With redundancy factor of \033[96;1m%.2f\033[0m, the bandwidth needed is: \033[96;1m%f Mbits/s\033[0m or \033[96;1m%f GB/month\033[0m\n", redunFactor, redunFactor*needBW[0], redunFactor*needBW[1]);

        } else {
            System.out.print("Input monthly usage ([quantity] [data unit(B - TB)]): ");
            input = scanner.nextLine();
            String usage = InputHandler.validateInput(input.toUpperCase(), "\\d+(?:\\.\\d+)?[\\s][KMGT]?B");
            String[] usageToken = usage.split(" ");

            System.out.print("Convert to? [bandwidth unit](bit/s - Tbit/s): ");
            input = scanner.nextLine();
            String bUnit = InputHandler.validateInput(input, "[KMGT]?bit/s");
            String unit = bUnit.substring(0, bUnit.lastIndexOf("b")+1).toLowerCase();
            double usageAmount = Double.parseDouble(usageToken[0]);
            String datUnit = usageToken[1];

            System.out.printf("\033[96;1m%.2f %s per month\033[0m is equivalent to \033[96;1m%f %s\033[0m\n",usageAmount, datUnit, usageAmount*unitConvert(datUnit, unit)/SECONDS_IN_MONTH, bUnit);
        }
    }

    public static double[] webBandwidth(String pageViews, String pageSize) {
        String[] pgViewsTokens = pageViews.split(" ");
        String[] pgSizeToken = pageSize.split(" ");
        double viewQuantity = Double.parseDouble(pgViewsTokens[0]);
        double size = Double.parseDouble(pgSizeToken[0]);
        String timeUnit = pgViewsTokens[2];
        String sizeUnit = pgSizeToken[1];

        double bandwidthMbits = (viewQuantity/timeConvert(timeUnit, "second")) * (size*unitConvert(sizeUnit, "mb"));
        double bandwidthGB = (viewQuantity/timeConvert(timeUnit, "month")) * (size*unitConvert(sizeUnit, "GB"));

        return new double[]{bandwidthMbits, bandwidthGB};
    }

    public static String DownUpTime(String fileSize, String bandwidth) {    // for file input of this, only take the first letter of the unit, lowercase, if its KMGT add b to it
        double size = Double.parseDouble(fileSize.substring(0, fileSize.length()-2));   // we cant make this assumption that unit is only 2 letter (kb, mb) data input unit will be in Bytes, Kilobytes...
        int lastIndexBW = bandwidth.matches("\\d+(?:\\.\\d+)?[\\s]?[KMGT]bit/s") ? bandwidth.lastIndexOf("b") - 1 : bandwidth.lastIndexOf("b");
        double sizeBW = Double.parseDouble(bandwidth.substring(0, lastIndexBW));
        String unit = fileSize.substring(fileSize.length()-2);
        String unitBW = bandwidth.substring(lastIndexBW, lastIndexBW+2).toLowerCase();

        double unitPerSecond =  size * unitConvert(unit, unitBW) / sizeBW;
        double days = unitPerSecond / SECONDS_IN_DAY,
                hours = (unitPerSecond % SECONDS_IN_DAY)/SECONDS_IN_HOUR,
                minutes = (unitPerSecond % SECONDS_IN_HOUR)/SECONDS_IN_MINUTE,
                seconds = (unitPerSecond % SECONDS_IN_MINUTE);

        return String.format("%.0f d : %.0f h : %.0f m : %.0f s", days, hours, minutes, seconds);
    }

    public static double unitConvert(String from, String to) {
        return switch (from) {
            case "kb" -> KILOBITS_TO_BITS;
            case "mb" -> MEGABITS_TO_BITS;
            case "gb" -> GIGABITS_TO_BITS;
            case "tb" -> TERABITS_TO_BITS;
            case "B" -> BYTES_TO_BITS;
            case "KB" -> KILOBYTES_TO_BITS;
            case "MB" -> MEGABYTES_TO_BITS;
            case "GB" -> GIGABYTES_TO_BITS;
            case "TB" -> TERABYTES_TO_BITS;
            default -> 1;
        } / switch (to) {
            case "kb" -> KILOBITS_TO_BITS;
            case "mb" -> MEGABITS_TO_BITS;
            case "gb" -> GIGABITS_TO_BITS;
            case "tb" -> TERABITS_TO_BITS;
            case "B" -> BYTES_TO_BITS;
            case "KB" -> KILOBYTES_TO_BITS;
            case "MB" -> MEGABYTES_TO_BITS;
            case "GB" -> GIGABYTES_TO_BITS;
            case "TB" -> TERABYTES_TO_BITS;
            default -> 1;
        };
    }

    public static double timeConvert(String from, String to) {
        return switch(from) {
            case "year" -> SECONDS_IN_YEAR;
            case "month" -> SECONDS_IN_MONTH;
            case "week" -> SECONDS_IN_WEEK;
            case "day" -> SECONDS_IN_DAY;
            case "hour" -> SECONDS_IN_HOUR;
            case "minute" -> SECONDS_IN_MINUTE;
            default -> 1;
        } / switch (to) {
            case "year" -> SECONDS_IN_YEAR;
            case "month" -> SECONDS_IN_MONTH;
            case "week" -> SECONDS_IN_WEEK;
            case "day" -> SECONDS_IN_DAY;
            case "hour" -> SECONDS_IN_HOUR;
            case "minute" -> SECONDS_IN_MINUTE;
            default -> 1;
        };
    }
}