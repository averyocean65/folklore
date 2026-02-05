package org.averyocean65.folklore.tests;

import org.averyocean65.folklore.Misc;
import org.junit.Assert;

public class TestEssentials {
    public static void compareDoubles(double expected, double result) {
        double error = expected - result;

        System.out.printf("Expected: %f, Value: %f, Error: %f%n", expected, result, error);
        Assert.assertTrue(Misc.areDoublesEqual(expected, result));
    }
}