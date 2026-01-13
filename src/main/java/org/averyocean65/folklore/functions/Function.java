package org.averyocean65.folklore.functions;

import jdk.jshell.spi.ExecutionControl;
import org.averyocean65.folklore.Misc;
import org.averyocean65.folklore.Operator;

public class Function {
    private FunctionPart[] parts;

    public Function(FunctionPart[] parts) {
        this.parts = parts;
    }

    public FunctionPart[] getParts() {
        return parts;
    }

    public FunctionPart getIndividualPart(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= parts.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return parts[index];
    }

    public void setParts(FunctionPart[] parts) {
        this.parts = parts;
    }

    public void setIndividualPart(int index, FunctionPart replace) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= parts.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        parts[index] = replace;
    }

    public double sampleFunction(double x) {
        double totalValue = 0;
        Operator operatorToNext = null;
        
        for(int i = 0; i < parts.length; i++) {
            FunctionPart part = parts[i];
            double sampled = part.sample(x);

            // ignore operatorToNext if i == 0
            if(i != 0) {
                totalValue = Misc.Combine(totalValue, sampled, operatorToNext);
            } else {
                totalValue = sampled;
            }

            operatorToNext = part.getOperatorToNext();
        }
        return totalValue;
    }
}