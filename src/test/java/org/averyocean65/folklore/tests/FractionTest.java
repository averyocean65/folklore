package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Fraction;
import org.junit.*;

public class FractionTest {
    private void decimalTest(Fraction f, float expected) {
        float converted = f.toDecimal();
        float error = expected - converted;

        System.out.println("Expected: %f".formatted(expected));
        System.out.println("Value: %f".formatted(converted));
        System.out.println("Error: %f".formatted(error));

        Assert.assertTrue(Math.abs(error) < 0.001f);
    }

    @Test
    public void testDecimalConversion() {
        decimalTest(new Fraction(3, 4), 0.75f);
        decimalTest(new Fraction(1, 2), 0.5f);
        decimalTest(new Fraction(2, 5), 0.4f);
        decimalTest(new Fraction(22, 7), 3.14285714286f);
    }
}
