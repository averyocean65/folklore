package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Fraction;
import org.averyocean65.folklore.Misc;
import org.junit.*;

public class FractionTest {
    private void fractionTest(Fraction f, double expected) {
        double converted = f.toDecimal();
        TestEssentials.compareDoubles(f.toDecimal(), expected);
    }

    @Test
    public void testDecimalConversion() {
        System.out.println("-- Testing Decimal Conversion --");

        fractionTest(new Fraction(3, 4), 0.75f);
        fractionTest(new Fraction(1, 2), 0.5f);
        fractionTest(new Fraction(2, 5), 0.4f);
        fractionTest(new Fraction(22, 7), 3.14285714286);
    }

    @Test
    public void testSimplification() {
        System.out.println("-- Testing Simplification --");

        Fraction extrapolated = new Fraction(12, 16);
        Fraction expected = new Fraction(3, 4);
        fractionTest(extrapolated.simplify(), expected.toDecimal());

        extrapolated = new Fraction(10, 30);
        expected = new Fraction(1, 3);
        fractionTest(extrapolated.simplify(), expected.toDecimal());
    }

    @Test
    public void testAddition() {
        System.out.println("-- Testing addition --");

        Fraction a = new Fraction(2, 5);
        Fraction b = new Fraction(6, 8);
        Fraction expected = new Fraction(23, 20);
        Fraction result = a.add(b);

        fractionTest(result, expected.toDecimal());

        a = new Fraction(   -57, 92);
        b = new Fraction(21, 106);
        expected = new Fraction(-2055, 4876);
        result = a.add(b);

        fractionTest(result, expected.toDecimal());
    }

    @Test
    public void testSubtraction() {
        System.out.println("-- Testing subtraction --");

        Fraction a = new Fraction(5, 4);
        Fraction b = new Fraction(7, 21);
        Fraction expected = new Fraction(11, 12);
        Fraction result = a.subtract(b);

        fractionTest(result, expected.toDecimal());

        a = new Fraction(   -52, 98);
        b = new Fraction(21, 106);
        expected = new Fraction(-3785, 5194);
        result = a.subtract(b);

        fractionTest(result, expected.toDecimal());
    }

    @Test
    public void testMultiplication() {
        System.out.println("-- Testing multiplication --");

        Fraction a = new Fraction(3, 9);
        Fraction b = new Fraction(1, 2);
        Fraction expected = new Fraction(3, 18);
        Fraction result = a.multiply(b);

        fractionTest(result, expected.toDecimal());

        a = new Fraction(   -2, 3);
        b = new Fraction(25, 100);
        expected = new Fraction(-50, 300);
        result = a.multiply(b);

        fractionTest(result, expected.toDecimal());
    }

    @Test
    public void testDivision() {
        System.out.println("-- Testing division --");

        Fraction a = new Fraction(8, 7);
        Fraction b = new Fraction(65, 1300);
        Fraction expected = new Fraction(160, 7);
        Fraction result = a.divide(b);

        fractionTest(result, expected.toDecimal());

        a = new Fraction(-87, 178);
        b = new Fraction(69, 8);
        expected = new Fraction(-116, 2047);
        result = a.divide(b);

        fractionTest(result, expected.toDecimal());
    }

    @Test
    public void testEquals() {
        System.out.println("-- Testing equality --");

        Fraction a = new Fraction(3, 4);
        Fraction b = new Fraction(12, 16);
        Assert.assertEquals(a, b);

        a = new Fraction(6, 12);
        b = new Fraction(12, 24);
        Assert.assertEquals(a, b);
    }
}