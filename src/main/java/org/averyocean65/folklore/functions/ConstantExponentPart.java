package org.averyocean65.folklore.functions;

import org.averyocean65.folklore.Operator;

public class ConstantExponentPart extends FunctionPart {
    private double amplification;
    private double exponent;
    private double yOffset;
    private double xShift;

    public ConstantExponentPart(double amplification, double exponent, Operator operatorToNext) {
        this(amplification, exponent, 0.0, 0.0, operatorToNext);
    }

    public ConstantExponentPart(double amplification, double exponent, double xShift, double yOffset, Operator operatorToNext) {
        super(operatorToNext);
        this.amplification = amplification;
        this.exponent = exponent;
        this.xShift = xShift;
        this.yOffset = yOffset;
    }

    public double getAmplification() {
        return amplification;
    }

    public void setAmplification(double amplification) {
        this.amplification = amplification;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public double getxShift() {
        return xShift;
    }

    public void setxShift(double xShift) {
        this.xShift = xShift;
    }

    @Override
    public double sample(double x) {
        return (amplification * Math.pow(x - xShift, exponent)) + yOffset;
    }
}
