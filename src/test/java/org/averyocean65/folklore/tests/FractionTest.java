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

    @Test
    public void testAddition() {
        System.out.println("-- Testing addition --");

        Fraction a = new Fraction(2, 5);
        Fraction b = new Fraction(6, 8);
        Fraction expected = new Fraction(23, 20);
        Fraction result = a.add(b);

        decimalTest(result, expected.toDecimal());

        a = new Fraction(   -57, 92);
        b = new Fraction(21, 106);
        expected = new Fraction(-2055, 4876);
        result = a.add(b);

        decimalTest(result, expected.toDecimal());
    }

    @Test
    public void testSubtraction() {
        System.out.println("-- Testing subtraction --");

        Fraction a = new Fraction(5, 4);
        Fraction b = new Fraction(7, 21);
        Fraction expected = new Fraction(11, 12);
        Fraction result = a.subtract(b);

        decimalTest(result, expected.toDecimal());

        a = new Fraction(   -52, 98);
        b = new Fraction(21, 106);
        expected = new Fraction(-3785, 5194);
        result = a.subtract(b);

        decimalTest(result, expected.toDecimal());
    }
}