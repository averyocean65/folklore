package org.averyocean65.folklore.vectors;

public interface VectorBase<T> {
    double getMagnitude();
    T getNormalized();
    double[] toArray();

    // arithmetic operations
    T add(T other);
    T subtract(T other);
    T multiply(T other);
    T multiply(double other);
    T divide(T other);
    T divide(double other);
}
