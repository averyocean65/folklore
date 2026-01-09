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

    public static boolean areFloatsEqual(float a, float b) {
        float error = Math.abs(a - b);
        return error < 0.00001f;
    }

    public static float Root(float base, float n) {
        if(areFloatsEqual(n, 1)) {
            return base;
        }

        if(areFloatsEqual(n, 2)) {
            return (float)Math.sqrt(base);
        }

        if(areFloatsEqual(n, 3)) {
            return (float)Math.cbrt(base);
        }

        float unrounded = (float) Math.pow(base, 1 / n);
        return (float) Math.round(unrounded * 1000f) / 1000f;
    }

    public static float Log(float num, float base) {
        return (float)(Math.log(num) / Math.log(base));
    }
}