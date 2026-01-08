package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Function;
import org.averyocean65.folklore.FunctionPart;
import org.averyocean65.folklore.Misc;
import org.averyocean65.folklore.Operator;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {
    @Test
    public void TestSquareFunction() {
        FunctionPart[] squareFunctionParts = new FunctionPart[] {
                new FunctionPart(1, 2, 0, 0, Operator.End)
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
        // 5 (x-2)^(3)+0.0025 x^(2)-2
        FunctionPart[] polynomialParts = new FunctionPart[] {
                new FunctionPart(5, 3, -2, 0, Operator.Addition),
                new FunctionPart(0.0025f, 2, 0, -2, Operator.End)
        };

        Function squareFunction = new Function(polynomialParts);
        float expectedZero = -42;
        float expectedOne = -6.9975f;
        float expectedTwo = -1.99f;
        float expectedThree = 3.0225f;

        float sampledZero = squareFunction.sampleFunction(0);
        float sampledOne = squareFunction.sampleFunction(1);
        float sampledTwo = squareFunction.sampleFunction(2);
        float sampledThree = squareFunction.sampleFunction(3);

        Assert.assertTrue(Misc.areFloatsEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areFloatsEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areFloatsEqual(expectedTwo, sampledTwo));
        Assert.assertTrue(Misc.areFloatsEqual(expectedThree, sampledThree));
    }
}
