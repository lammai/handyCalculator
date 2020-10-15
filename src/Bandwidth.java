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

    public Bandwidth() {
        selectOperation();
    }

    private void selectOperation() {
        System.out.println("Select which Bandwidth calculation to perform:");
        System.out.println("1. Data unit converter:");
        System.out.println("2. Download/Upload time calculator:");
        System.out.println("3. Website bandwidth calculator:");
        System.out.println("4. Hosting bandwidth calculator:");
        System.out.print(">>> ");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(Ult.validateInput(input, "[1-4]+"));

        if (choice == 1) {
            System.out.print("Input data size and unit(b-TB): ");
            input = scanner.nextLine().trim();
            String validatedInput = Ult.validateInput(input, "[0-9]+[\\s]?[kmgtKMGT]?[bB]");

            double dataSize = Double.parseDouble(validatedInput.substring(0, validatedInput.length()-2));
            String inpUnit = validatedInput.substring(validatedInput.length()-2);
            System.out.printf("%s is equivalent to any of the following:\n", validatedInput);
            for (String unit : units) {
                if (!unit.equals(inpUnit))
                    System.out.println(dataSize*unitConvert(inpUnit, unit) + " " + unit);
            }
        }
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
}