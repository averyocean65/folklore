package org.averyocean65.folklore;

import java.util.List;

public class Function {
    private FunctionPart[] parts;

    public Function(FunctionPart[] pParts) {
        parts = pParts;
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

    public float sampleFunction(float x) throws IllegalStateException {
        if(parts.length == 1) {
            return parts[0].sampleOwnValue(x);
        }

        Operator leftover = null;
        float totalValue = 0.0f;
        for(int i = 0; i < parts.length; i++) {
            float sampled = parts[i].sampleOwnValue(x);

            // Skip operator work if we're on the first part of the function
            if(i == 0) {
                totalValue = sampled;
                leftover = parts[i].operatorToNext();
                continue;
            }

            // Time to do some operations
            switch(leftover) {
                case Addition -> {
                    totalValue += sampled;
                }
                case Subtraction -> {
                    totalValue -= sampled;
                }
                case Multiplication -> {
                    totalValue *= sampled;
                }
                case Division -> {
                    totalValue /= sampled;
                }
                default -> throw new IllegalStateException("parts[%d].operatorToNext()");
            }

            // Get the new leftover operator
            leftover = parts[i].operatorToNext();
        }

        return totalValue;
    }
}