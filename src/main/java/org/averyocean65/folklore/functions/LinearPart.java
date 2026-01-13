package org.averyocean65.folklore.functions;

import org.averyocean65.folklore.Operator;

public class LinearPart extends FunctionPart {
    private double amplification;
    private double yOffset;
    
    public LinearPart(double amplification, double yOffset, Operator operatorToNext) {
        super(operatorToNext);
        this.amplification = amplification;
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

    @Override
    public double sample(double x) {
        return (amplification * x) + yOffset;
    }
}
