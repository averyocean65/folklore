package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Misc;
import org.junit.Assert;
import org.junit.Test;

public class MiscTest {
    @Test
    public void testFloatEquality() {
        double a = 0.001f;
        double b = 0.02f;
        Assert.assertFalse(Misc.areDoublesEqual(a, b));

        a = 1e8f;
        b = 1e8f;
        Assert.assertTrue(Misc.areDoublesEqual(a, b));

        a = 1e-6f;
        b = 1e-6f;
        Assert.assertTrue(Misc.areDoublesEqual(a, b));
    }

    @Test
    public void testFactorial() {
        int expected = 5 * 4 * 3 * 2;
        int result = Misc.factorial(5);
        Assert.assertEquals(expected, result);

        expected = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
        result = Misc.factorial(10);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testRoots() {
        double cbrtExpected = (double)Math.cbrt(125);
        double cbrtResult = Misc.Root(125, 3);
        Assert.assertTrue(Misc.areDoublesEqual(cbrtExpected, cbrtResult));
    }
}
