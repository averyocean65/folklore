package org.averyocean65.folklore.vectors;

public interface VectorBase<T> {
    public double getMagnitude();
    public T getScaled(double factor);
    public T getNormalized();
    public double[] toArray();
}
