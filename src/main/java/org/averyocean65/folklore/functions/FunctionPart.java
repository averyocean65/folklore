package org.averyocean65.folklore.functions;

import org.averyocean65.folklore.Operator;

public abstract class FunctionPart {
    private Operator operatorToNext;

    protected FunctionPart(Operator operatorToNext) {
        operatorToNext = operatorToNext;
    }

    public Operator getOperatorToNext() {
        return operatorToNext;
    }

    public void setOperatorToNext(Operator operatorToNext) {
        this.operatorToNext = operatorToNext;
    }

    public abstract double sample(double x);
}
