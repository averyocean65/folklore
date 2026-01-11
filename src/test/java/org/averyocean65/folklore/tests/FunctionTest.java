package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {
    @Test
    public void TestSquareFunction() {
        System.out.println("-- Testing \"x^(2)\" --");

        FunctionPart[] squareFunctionParts = new FunctionPart[] {
                new FunctionPart(1, 2, 0, 0, Operator.End, FunctionPartType.Default)
        };

        Function squareFunction = new Function(squareFunctionParts);
        double expectedZero = 0;
        double expectedOne = 1;
        double expectedTwo = 4;
        double expectedThree = 9;

        double sampledZero = squareFunction.sampleFunction(0);
        double sampledOne = squareFunction.sampleFunction(1);
        double sampledTwo = squareFunction.sampleFunction(2);
        double sampledThree = squareFunction.sampleFunction(3);

        Assert.assertTrue(Misc.areDoublesEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areDoublesEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestPolynomialA() {
        System.out.println("-- Testing \"5 * (x-2)^(3) + 0.0025 x^(2) - 2\" --");

        // 5 (x-2)^(3)+0.0025 x^(2)-2
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(5, 3, -2, 0, Operator.Addition, FunctionPartType.Default),

                // end operator is optional in this case
                new FunctionPart(0.0025, 2, 0, -2, Operator.End, FunctionPartType.Default)
        };

        Function polynomial = new Function(polynomialParts);
        double expectedZero = -42;
        double expectedOne = -6.9975;
        double expectedTwo = -1.99;
        double expectedThree = 3.0225;

        double sampledZero = polynomial.sampleFunction(0);
        double sampledOne = polynomial.sampleFunction(1);
        double sampledTwo = polynomial.sampleFunction(2);
        double sampledThree = polynomial.sampleFunction(3);

        Assert.assertTrue(Misc.areDoublesEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areDoublesEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestNaturalLogarithm() {
        System.out.println("-- Testing \"ln(x)\" --");

        // ln(x)
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(1, 1, 0, 0, Operator.End, FunctionPartType.Ln)
        };

        Function polynomial = new Function(polynomialParts);
        double expectedOne = 0;
        double expectedTwo = 0.6931471805599;
        double expectedThree = 1.0986122886681;

        double sampledOne = polynomial.sampleFunction(1);
        double sampledTwo = polynomial.sampleFunction(2);
        double sampledThree = polynomial.sampleFunction(3);

        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areDoublesEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestLogarithm() {
        System.out.println("-- Testing \"log_3(x)\" --");

        // ln(x)
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(1, 1, 0, 3, Operator.End, FunctionPartType.Log)
        };

        Function polynomial = new Function(polynomialParts);
        double expectedOne = 0;
        double expectedTwo = 0.6309297535715;
        double expectedThree = 1;

        double sampledZero = polynomial.sampleFunction(0);
        double sampledOne = polynomial.sampleFunction(1);
        double sampledTwo = polynomial.sampleFunction(2);
        double sampledThree = polynomial.sampleFunction(3);

        System.out.println(sampledZero);
        System.out.println(sampledOne);
        System.out.println(sampledTwo);
        System.out.println(sampledThree);

        Assert.assertTrue(Double.isInfinite(sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areDoublesEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestSin() {
        System.out.println("-- Testing \"sin(x)\" --");

        // ln(x)
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(1, 1, 0, 1, Operator.End, FunctionPartType.Sin)
        };

        Function polynomial = new Function(polynomialParts);
        double expectedZero = 0;
        double expectedHalfPi = 1;
        double expectedPi = 0;

        double sampledZero = polynomial.sampleFunction(0);
        double sampledHalfPi = polynomial.sampleFunction(Math.PI / 2);
        double sampledPi = polynomial.sampleFunction(Math.PI);

        Assert.assertTrue(Misc.areDoublesEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedHalfPi, sampledHalfPi));
        Assert.assertTrue(Misc.areDoublesEqual(expectedPi, sampledPi));
    }

    @Test
    public void TestArcSin() {
        System.out.println("-- Testing \"arcsin(x)\" --");

        // ln(x)
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(1, 1, 0, 1, Operator.End, FunctionPartType.ArcSin)
        };

        Function polynomial = new Function(polynomialParts);
        double expectedNegativeOne = -1.5707963267949;
        double expectedZero = 0;
        double expectedOne = 1.5707963267949;

        double sampledNegativeOne = polynomial.sampleFunction(-1);
        double sampledZero = polynomial.sampleFunction(0);
        double sampledOne = polynomial.sampleFunction(1);

        Assert.assertTrue(Misc.areDoublesEqual(expectedNegativeOne, sampledNegativeOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
    }
}
