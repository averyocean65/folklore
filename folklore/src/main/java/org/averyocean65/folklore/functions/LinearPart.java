package org.averyocean65.folklore.functions;

import org.averyocean65.folklore.Operator;

public class LinearPart extends FunctionPart {
    private double amplification;
    private double yOffset;
    private double xShift;

    public LinearPart(double amplification, double yOffset, Operator operatorToNext) {
        this(amplification, yOffset, 0, operatorToNext);
    }

    public LinearPart(double amplification, double yOffset, double xShift, Operator operatorToNext) {
        super(operatorToNext);
        this.amplification = amplification;
        this.xShift = xShift;
        this.yOffset = yOffset;
    }

    public double getAmplification() {
        return amplification;
    }

    public void setAmplification(double amplification) {
        this.amplification = amplification;
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
        return (amplification * (x - xShift)) + yOffset;
    }
}
