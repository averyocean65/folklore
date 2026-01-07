package org.averyocean65.folklore;

public class Fraction {
    private int numerator;
    private int denominator;

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
     * @return
     */
    public float toDecimal() {
        return (float)numerator / (float)denominator;
    }

    /**
     * Simplifies the fraction into the smallest form factor it can be.
     * @return the simplified fraction.
     */
    public Fraction simplify() {
        int gcd = Misc.gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }
}
