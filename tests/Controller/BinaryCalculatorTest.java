package Controller;

import Model.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    private int inputInt1, inputInt2;
    private Binary numInt1, numInt2;

    @BeforeEach
    void setUp() {
        Random rand = new Random();
        this.inputInt1 = rand.nextInt(Integer.MAX_VALUE);
        this.inputInt2 = rand.nextInt(Integer.MAX_VALUE);
        this.numInt1 = new Binary(Long.toBinaryString(inputInt1));
        this.numInt2 = new Binary(Long.toBinaryString(inputInt2));
    }

    @Test
    void add2Binary() {
        new BinaryCalculator(numInt1).add(numInt2);
        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).add(new BigDecimal(inputInt2)).longValueExact()), numInt1.getValue());
    }

//    @Test // in progress
//    void subtract2Binary() {
//        new BinaryCalculator(numInt1).subtract(numInt2);
//        assertEquals(Long.toBinaryString(new BigDecimal(inputInt1).subtract(new BigDecimal(inputInt2)).longValueExact()), numInt1.getValue());
//    }
}