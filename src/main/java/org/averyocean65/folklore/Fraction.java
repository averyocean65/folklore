package org.averyocean65.folklore;

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Creates a new fraction
     * @param numerator the number on top of the fraction
     * @param denominator the number on the bottom of the fraction
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Returns the fraction represented as a decimal number.
     * @return the decimal value.
     */
    public double toDecimal() {
        return (double)numerator / (double)denominator;
    }

    /**
     * Simplifies the fraction into the smallest form factor it can be.
     * @return the simplified fraction.
     */
    public Fraction simplify() {
        int gcd = Misc.gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    /**
     * Swaps the numerator and denominator of a fraction.
     * i.e. 17/4 --> 4/17
     * @return the inverted fraction.
     */
    public Fraction inverse() {
        return new Fraction(denominator, numerator);
    }

    /**
     * Scales a fraction by a scalar value. i.e. 1/2 scaled with 4 -> 4/8
     * @param scalar
     * @return the scaled fraction.
     */
    public Fraction scaleFraction(int scalar) {
        return multiply(new Fraction(scalar, scalar));
    }

    /**
     * Adds two fractions together
     * @param other
     * @return the added together fractions
     */
    public Fraction add(Fraction other) {
        int lcm = Misc.lcm(denominator, other.getDenominator());
        Fraction a = scaleFraction(lcm / denominator);
        Fraction b = other.scaleFraction(lcm / other.getDenominator());

        return new Fraction(a.getNumerator() + b.getNumerator(), lcm);
    }

    /**
     * Subtracts two fractions from another
     * @param other the fraction to subtract by
     * @return the added together fractions
     */
    public Fraction subtract(Fraction other) {
        Fraction duplicate = other;
        duplicate.setNumerator(other.getNumerator() * -1);
        return add(duplicate);
    }

    /**
     * multiplies two fractions together
     * @param other
     * @return the multiplied fractions
     */
    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    /**
     * Divides two fractions from another
     * @param other the fraction to divide with
     * @return the divided fraction
     */
    public Fraction divide(Fraction other) {
        return multiply(other.inverse());
    }

    @Override
    public boolean equals(Object other) throws IllegalArgumentException {
        if(other.getClass() == Fraction.class) {
            Fraction frac = (Fraction)other;
            return Misc.areDoublesEqual(toDecimal(), frac.toDecimal());
        }

        if(other.getClass() == Double.class) {
            double num = (double)other;
            return Misc.areDoublesEqual(toDecimal(), num);
        }

        throw new IllegalArgumentException();
    }
}
