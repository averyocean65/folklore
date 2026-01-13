package org.averyocean65.folklore.functions;

import org.averyocean65.folklore.Operator;

public class VariableExponentPart extends FunctionPart {
    private double base;
    private double exponentAmplification;
    private double xShift;
    private double yOffset;


    public VariableExponentPart(double base, double exponentAmplification, Operator operatorToNext) {
        this(base, exponentAmplification, 0.0, 0.0, operatorToNext);
    }

    public VariableExponentPart(double base, double xShift, double yOffset, Operator operatorToNext) {
        this(base, 1.0, xShift, yOffset, operatorToNext);
    }

    public VariableExponentPart(double base, double exponentAmplification, double xShift, double yOffset, Operator operatorToNext) {
        super(operatorToNext);
        this.base = base;
        this.exponentAmplification = exponentAmplification;
        this.xShift = xShift;
        this.yOffset = yOffset;
    }

    @Override
    public double sample(double x) {
        double exponent = exponentAmplification * (x - xShift);
        return Math.pow(base, exponent) + yOffset;
    }
}
