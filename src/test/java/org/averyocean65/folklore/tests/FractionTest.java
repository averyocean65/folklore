package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Fraction;
import org.junit.*;

public class FractionTest {
    private void decimalTest(Fraction f, float expected) {
        float converted = f.toDecimal();
        float error = expected - converted;

        System.out.println("Expected: %f, Value: %f, Error: %f"
                .formatted(expected, converted, error)
        );

        Assert.assertTrue(Math.abs(error) < 0.001f);
    }

    @Test
    public void testDecimalConversion() {
        System.out.println("-- Testing Decimal Conversion --");

        decimalTest(new Fraction(3, 4), 0.75f);
        decimalTest(new Fraction(1, 2), 0.5f);
        decimalTest(new Fraction(2, 5), 0.4f);
        decimalTest(new Fraction(22, 7), 3.14285714286f);
    }

    @Test
    public void testSimplification() {
        System.out.println("-- Testing Simplification --");

        Fraction extrapolated = new Fraction(12, 16);
        Fraction expected = new Fraction(3, 4);
        decimalTest(extrapolated.simplify(), expected.toDecimal());

        extrapolated = new Fraction(10, 30);
        expected = new Fraction(1, 3);
        decimalTest(extrapolated.simplify(), expected.toDecimal());
    }
}