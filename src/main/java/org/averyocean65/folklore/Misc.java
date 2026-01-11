package org.averyocean65.folklore;

public class Misc {
    /**
     * Returns the greatest common divisor of two integer numbers.
     * This is also known as the HCF (highest common factor).
     * @param a
     * @param b
     * @return the calculated divisor.
     */
    public static int gcd(int a, int b) {
        int c = b;
        int d = a % b;

        while(d != 0) {
            int temp = d;
            d = c % d;
            c = temp;
        }

        return c;
    }

    /**
     * Calculates the least common multiplier of two numbers.
     * @param a
     * @param b
     * @return the calculated multiplier.
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int factorial(int base) {
        int totalValue = 1;
        for(int i = base; i > 1; i--) {
            totalValue *= i;
        }
        return totalValue;
    }

    public static boolean areDoublesEqual(double a, double b) {
        return areDoublesEqual(a, b, true);
    }

    public static boolean areDoublesEqual(double a, double b, boolean extraPrecision) {
        double error = Math.abs(a - b);
        double errorMargin = extraPrecision ? 0.00001f : 0.001f;
        return error < errorMargin;
    }

    public static double Root(double base, double n) {
        if(areDoublesEqual(n, 1)) {
            return base;
        }

        if(areDoublesEqual(n, 2)) {
            return Math.sqrt(base);
        }

        if(areDoublesEqual(n, 3)) {
            return Math.cbrt(base);
        }

        double unrounded = Math.pow(base, 1 / n);
        return (double) Math.round(unrounded * 1000f) / 1000f;
    }

    public static double Log(double num, double base) {
        return (Math.log(num) / Math.log(base));
    }
}