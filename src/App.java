import Controller.*;
import Model.*;
import View.NumberSystem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This Calculator program support Binary and Hexadecimal conversions as well as basic calculations.
 * It includes a Bandwidth calculator that features data unit conversions and other bandwidth related utilities.
 * It also enable the user to get output of multiple calculations by providing a text file.
 *
 * @author Lam Mai
 * @version 1.0
 * @since 10-16-2020
 */
public class App {

    /**
     * The main method serves as the main menu for the calculator, direct the user's choice to the corresponding
     * calculator.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("\033[96m█▀▀ ▄▀█ █░░ █▀▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█");
        System.out.println("\033[96m█▄▄ █▀█ █▄▄ █▄▄ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄\033[0m");

        Hex h = new Hex("AA");
        Hex h2 = new Hex("AB");
        System.out.println(h.toString());
        System.out.println(h2.toString());
        System.out.println(h.compareTo(h2));
        System.out.println(h.compareTo(h));
        System.out.println(h2.compareTo(h));
        System.out.println(h.equals(h2));
        System.out.println(h.equals(h));
        System.out.println();

        SizeUnit test = new SizeUnit("41390", SizeUnit.Size.GIGABYTES);
        System.out.println(test.getValue());
        System.out.println(test.getUnit());
        System.out.println(test.getUnitInBits());
        System.out.println();

        Hex hex = new Hex("625AFF2E23DC1");
        HexCalculator hexCalc = new HexCalculator(hex);
        System.out.println(hexCalc.convertToHex().toString());
        System.out.println(hexCalc.convertToDec().toString());
        System.out.println(hexCalc.convertToBin().toString());

        Decimal deci = new Decimal("1730287484681665");
        DecimalCalculator calc = new DecimalCalculator(deci);
        System.out.println(calc.convertToBin().toString());
        System.out.println(calc.convertToHex().toString());
        System.out.println();

        Decimal bi = new Decimal("23489");

        System.out.println("first binary: " + bi.toString());
//        System.out.println("Original binaryCalc: " + biCalc.getNum().toString());
        Decimal bi2 = new Decimal("3478");
        System.out.println("second binary: " +bi2.toString());
        new DecimalCalculator(bi).add(bi2);
//        biCalc.add(bi2);
        System.out.println("first binary: " + bi.toString());
        System.out.println("second binary: " +bi2.toString());
//        System.out.println("Original binaryCalc: " + biCalc.getNum().toString());
        System.out.println();


        Binary boi = new Binary("10101010");
        System.out.println(boi.toString());
        Binary boi2 = new Binary("10111101001010");
        System.out.println(boi2.toString());
        new BinaryCalculator(boi).add(boi2);
        System.out.println(boi.toString());
        System.out.println();

        Binary boii = new Binary("10101010");
        System.out.println(boii.toString());
        Binary boii2 = new Binary("10111101001010");
        System.out.println(boii2.toString());
        new BinaryCalculator(boii).subtract(boii2);
        System.out.println(boii.toString());
        System.out.println();

        Binary boiii = new Binary("10101010");
        System.out.println(boiii.toString());
        Binary boiii2 = new Binary("10111101001010");
        System.out.println(boiii2.toString());
        new BinaryCalculator(boiii).multiply(boiii2);
        System.out.println(boiii.toString());
        System.out.println();

        Binary boiiii = new Binary("101011101101");
        System.out.println(boiiii.toString());
        Binary boiiii2 = new Binary("1010101110100001001111");
        System.out.println(boiiii2.toString());
        String[] remainders = new BinaryCalculator(boiiii).divide(boiiii2);
        System.out.println(boiiii);
        System.out.println("Decimal remainder: " + remainders[0] + "  Binary: " + remainders[1]);
        System.out.println();

        Hex hex1 = new Hex("8ABac");
        System.out.println(hex1.toString());
        Hex hex2 = new Hex("B78fd");
        System.out.println(hex2.toString());
        String[] hexMainder = new HexCalculator(hex1).divide(hex2);
        System.out.println(hex1.toString());
        System.out.println("Decimal remainder: " + hexMainder[0] + "  hex: " + hexMainder[1]);
        System.out.println();

        Decimal wtf = new Decimal("568236");
        Decimal wtf2 = new Decimal("751869");
        new DecimalCalculator(wtf).divide(wtf2);
        System.out.println(wtf.toString());
        System.out.println();

        SizeUnit size = new SizeUnit("34587923490", SizeUnit.Size.GIGABITS);
        SizeUnit.Size[] units = SizeUnit.Size.values();
        for (SizeUnit.Size s: units) {
            System.out.println(BigDecimal.valueOf(Long.parseLong(size.getValue()) * (size.getUnitInBits() / s.toBits)).toPlainString() + " " + s.toString().toLowerCase());
        }
        System.out.println();

        DownloadUploadCalculator ass = new DownloadUploadCalculator(new Decimal("378829"), SizeUnit.Size.MEGABYTES, new Decimal("5"), RateUnit.Rate.BIT_PER_SECOND);
        String[] result = ass.calculate();
        System.out.println(Arrays.toString(result));

        WebsiteBandwidthCalculator web = new WebsiteBandwidthCalculator(new Decimal("43"), TimeUnit.Time.DAY, new Decimal("500"), SizeUnit.Size.KILOBYTES, 2);
        String[] oi = web.calculate();
        System.out.println(Arrays.toString(oi));

        HostingBandwidthCalculator hos = new HostingBandwidthCalculator(new Decimal("1000"), SizeUnit.Size.GIGABYTES, RateUnit.Rate.BIT_PER_SECOND);
        String resultHos = hos.convert();
        System.out.println(resultHos);
        HostingBandwidthCalculator hos2 = new HostingBandwidthCalculator(new Decimal("1000"), RateUnit.Rate.GIGABIT_PER_SECOND, SizeUnit.Size.KILOBYTES);
        String resultHos2 = hos2.convert();
        System.out.println(resultHos2);
        System.out.println();

        Binary testBin = new Binary("10101011");
        System.out.println(testBin.toString());
        String inp = "10101";
        performCalculation(testBin, "+", inp);
        System.out.println(testBin.toString());


        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("\033[1;4mPlease select from the following options: \033[0m");
        System.out.println("\033[91m1\033[0m: Binary Calculator");
        System.out.println("\033[91m2\033[0m: Hex Calculator");
        System.out.println("\033[91m3\033[0m: Bandwidth Calculator");
        System.out.println("\033[91m4\033[0m: Input data file");
        System.out.println("\033[91mq\033[0m: Quit");
        do {
            System.out.print("\033[31;1;3mMain Menu Selection >>> \033[0m");
            input = scanner.nextLine();
            String userChoice = InputHandler.validateInput(input, "[1-4q]");

            System.out.println("\033[96m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\033[0m");
            switch (userChoice) {
                case "1" -> new BinaryHex(NumberSystem.Binary);
                case "2" -> new BinaryHex(NumberSystem.Hex);
                case "3" -> new Bandwidth();
                case "4" -> InputHandler.fileIO();
            }
        }while (!input.equals("q"));
    }

    public static void performCalculation(Binary bin, String op, String var2) {
        new BinaryCalculator(bin).add(new Binary(var2));
    }
}