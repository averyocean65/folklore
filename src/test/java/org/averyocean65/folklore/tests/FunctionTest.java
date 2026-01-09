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
        float expectedZero = 0;
        float expectedOne = 1;
        float expectedTwo = 4;
        float expectedThree = 9;

        float sampledZero = squareFunction.sampleFunction(0);
        float sampledOne = squareFunction.sampleFunction(1);
        float sampledTwo = squareFunction.sampleFunction(2);
        float sampledThree = squareFunction.sampleFunction(3);

        Assert.assertTrue(Misc.areFloatsEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areFloatsEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areFloatsEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areFloatsEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestPolynomialA() {
        System.out.println("-- Testing \"5 * (x-2)^(3) + 0.0025 x^(2) - 2\" --");

        // 5 (x-2)^(3)+0.0025 x^(2)-2
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(5, 3, -2, 0, Operator.Addition, FunctionPartType.Default),

                // end operator is optional in this case
                new FunctionPart(0.0025f, 2, 0, -2, Operator.End, FunctionPartType.Default)
        };

        Function polynomial = new Function(polynomialParts);
        float expectedZero = -42;
        float expectedOne = -6.9975f;
        float expectedTwo = -1.99f;
        float expectedThree = 3.0225f;

        float sampledZero = polynomial.sampleFunction(0);
        float sampledOne = polynomial.sampleFunction(1);
        float sampledTwo = polynomial.sampleFunction(2);
        float sampledThree = polynomial.sampleFunction(3);

        Assert.assertTrue(Misc.areFloatsEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areFloatsEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areFloatsEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areFloatsEqual(expectedThree, sampledThree));
    }

    @Test
    public void TestLogarithm() {
        System.out.println("-- Testing \"ln(x)\" --");

        // ln(x)
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(1, 1, 0, 0, Operator.End, FunctionPartType.Ln)
        };

        Function polynomial = new Function(polynomialParts);
        float expectedOne = 0;
        float expectedTwo = 0.6931471805599f;
        float expectedThree = 1.0986122886681f;

        float sampledOne = polynomial.sampleFunction(1);
        float sampledTwo = polynomial.sampleFunction(2);
        float sampledThree = polynomial.sampleFunction(3);

        Assert.assertTrue(Misc.areFloatsEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areFloatsEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areFloatsEqual(expectedThree, sampledThree));
    }
}
