package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.*;
import org.averyocean65.folklore.functions.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {
    @Test
    public void testLinear() {
        Function myFunction = new Function(new FunctionPart[] {
                new LinearPart(1, 0, Operator.Addition)
        });

        double expectedZero = 0;
        double expectedOne = 1;
        double expectedTwo = 2;

        double sampledZero = myFunction.sample(0);
        double sampledOne = myFunction.sample(1);
        double sampledTwo = myFunction.sample(2);

        Assert.assertTrue(Misc.areDoublesEqual(expectedZero, sampledZero));
        Assert.assertTrue(Misc.areDoublesEqual(expectedOne, sampledOne));
        Assert.assertTrue(Misc.areDoublesEqual(expectedTwo, sampledTwo));
    }
}
