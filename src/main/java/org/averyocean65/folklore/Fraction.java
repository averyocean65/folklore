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
     * @return the decimal value.
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

    /**
     * Swaps the numerator and denominator of a fraction.
     * i.e. 17/4 --> 4/17
     * @return the inversed fraction.
     */
    public Fraction inverse() {
        return new Fraction(denominator, numerator);
    }

    public Fraction scaleFraction(int scalar) {
        return multiply(new Fraction(scalar, scalar));
    }

    public Fraction add(Fraction other) {
        int lcm = Misc.lcm(denominator, other.getDenominator());
        Fraction a = scaleFraction(lcm / denominator);
        Fraction b = other.scaleFraction(lcm / other.getDenominator());

        return new Fraction(a.getNumerator() + b.getNumerator(), lcm);
    }

    public Fraction subtract(Fraction other) {
        int lcm = Misc.lcm(denominator, other.getDenominator());
        Fraction a = scaleFraction(lcm / denominator);
        Fraction b = other.scaleFraction(lcm / other.getDenominator());

        return new Fraction(a.getNumerator() - b.getNumerator(), lcm);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    public Fraction divide(Fraction other) {
        return multiply(other.inverse());
    }
}
