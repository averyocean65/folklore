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

        TestEssentials.compareDoubles(expectedZero, sampledZero);
        TestEssentials.compareDoubles(expectedOne, sampledOne);
        TestEssentials.compareDoubles(expectedTwo, sampledTwo);
    }

    @Test
    public void testQuadratic() {
        Function myFunction = new Function(new FunctionPart[] {
                new ConstantExponentPart(1, 2, 0, 0, Operator.Addition)
        });

        double expectedZero = 0;
        double expectedOne = 1;
        double expectedTwo = 4;
        double expectedThree = 9;
        double expectedFour = 16;

        double sampledZero = myFunction.sample(0);
        double sampledOne = myFunction.sample(1);
        double sampledTwo = myFunction.sample(2);
        double sampledThree = myFunction.sample(3);
        double sampledFour = myFunction.sample(4);

        TestEssentials.compareDoubles(expectedZero, sampledZero);
        TestEssentials.compareDoubles(expectedOne, sampledOne);
        TestEssentials.compareDoubles(expectedTwo, sampledTwo);
        TestEssentials.compareDoubles(expectedThree, sampledThree);
        TestEssentials.compareDoubles(expectedFour, sampledFour);
    }

    @Test
    public void testBasicVariableExponent() {
        Function myFunction = new Function(new FunctionPart[] {
                new VariableExponentPart(2, 1, Operator.Addition)
        });

        double expectedZero = 1;
        double expectedOne = 2;
        double expectedTwo = 4;
        double expectedThree = 8;
        double expectedFour = 16;

        double sampledZero = myFunction.sample(0);
        double sampledOne = myFunction.sample(1);
        double sampledTwo = myFunction.sample(2);
        double sampledThree = myFunction.sample(3);
        double sampledFour = myFunction.sample(4);

        TestEssentials.compareDoubles(expectedZero, sampledZero);
        TestEssentials.compareDoubles(expectedOne, sampledOne);
        TestEssentials.compareDoubles(expectedTwo, sampledTwo);
        TestEssentials.compareDoubles(expectedThree, sampledThree);
        TestEssentials.compareDoubles(expectedFour, sampledFour);
    }

    @Test
    public void testFullVariableExponent() {
        Function myFunction = new Function(new FunctionPart[] {
                new VariableExponentPart(6, 0.25, 2, 2.25, Operator.Addition)
        });

        double expectedZero = 2.6582482904639;
        double expectedOne = 2.8889431042463;
        double expectedTwo = 3.25;
        double expectedThree = 3.8150845800733;
        double expectedFour = 4.6994897427832;

        double sampledZero = myFunction.sample(0);
        double sampledOne = myFunction.sample(1);
        double sampledTwo = myFunction.sample(2);
        double sampledThree = myFunction.sample(3);
        double sampledFour = myFunction.sample(4);

        TestEssentials.compareDoubles(expectedZero, sampledZero);
        TestEssentials.compareDoubles(expectedOne, sampledOne);
        TestEssentials.compareDoubles(expectedTwo, sampledTwo);
        TestEssentials.compareDoubles(expectedThree, sampledThree);
        TestEssentials.compareDoubles(expectedFour, sampledFour);
    }
}
