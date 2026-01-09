package org.averyocean65.folklore.vectors;

public interface VectorBase<T> {
    public float getMagnitude();
    public T getScaled(float factor);
    public T getNormalized();
    public float[] toArray();
}
