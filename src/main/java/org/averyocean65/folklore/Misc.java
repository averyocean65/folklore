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

    /**
     * Returns the factorial form of a number, following the formula: {@code (n - 0) * (n - 1) * (n - 2) * (n - 3) * ...}.<br>
     * Example: factorial(5) = 5! = 5 * 4 * 3 * 2 * 1 = 120.
     * @param n the number to get the factorial of.
     * @return the factorial of n.
     */
    public static int factorial(int n) {
        int totalValue = 1;
        for(int i = n; i > 1; i--) {
            totalValue *= i;
        }
        return totalValue;
    }

    /**
     * Checks if the difference of two doubles is near zero, therefore checking if they are approximately equal.
     * @param a the first double.
     * @param b the second double.
     * @return returns whether the numbers are approximately equal or not.
     */
    public static boolean areDoublesEqual(double a, double b) {
        return areDoublesEqual(a, b, true);
    }

    /**
     * Checks if the difference of two doubles is within a certain error, therefore checking if they are approximately equal.
     * @param a the first double.
     * @param b the second double.
     * @param extraPrecision toggles whether to use extra precision or not.
     * @return returns whether the numbers are approximately equal or not.
     */
    public static boolean areDoublesEqual(double a, double b, boolean extraPrecision) {
        double error = Math.abs(a - b);
        double errorMargin = extraPrecision ? 0.00001 : 0.001;
        return error < errorMargin;
    }

    /**
     * Takes the nth root of a number.
     * @param base the number to take the root from.
     * @param n the degree of the root.
     * @return the nth root of base.
     */
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

    /**
     * Returns a logarithm with the nth base.
     * @param num the number to take the logarithm from.
     * @param n the base of the logarithm.
     * @return the logarithm of base n.
     */
    public static double Log(double num, double n) {
        return (Math.log(num) / Math.log(n));
    }

    /**
     * Combines two doubles based on a value from the Operator enum.
     * @param a the left side of the equation.
     * @param b the right side of the equation.
     * @param operator the operation to perform.
     * @return the combined numbers.
     */
    public static double Combine(double a, double b, Operator operator) {
        switch (operator) {
            case Addition -> {
                return a + b;
            }
            case Subtraction -> {
                return a - b;
            }
            case Multiplication -> {
                return a * b;
            }
            case Division -> {
                return a / b;
            }
        }
    }
}