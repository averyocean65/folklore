package org.averyocean65.folklore.vectors;

public class Vector2 implements VectorBase<Vector2> {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getMagnitude() {
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public Vector2 getScaled(double factor) {
        return null;
    }

    @Override
    public Vector2 getNormalized() {
        double newX = x / getMagnitude();
        double newY = y / getMagnitude();
        return new Vector2(newX, newY);
    }

    @Override
    public double[] toArray() {
        return new double[] { x, y };
    }
}
