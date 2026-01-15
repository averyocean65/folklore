package org.averyocean65.folklore.vectors;

public class Vector2 implements VectorBase<Vector2> {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getMagnitude() {
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public Vector2 getNormalized() {
        return divide(getMagnitude());
    }

    @Override
    public double[] toArray() {
        return new double[] { x, y };
    }

    @Override
    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.getX(), y + other.getY());
    }

    @Override
    public Vector2 subtract(Vector2 other) {
        return new Vector2(x - other.getX(), y - other.getY());
    }

    @Override
    public Vector2 multiply(Vector2 other) {
        return new Vector2(x * other.getX(), y * other.getY());
    }

    @Override
    public Vector2 multiply(double other) {
        return new Vector2(x * other, y * other);
    }

    @Override
    public Vector2 divide(Vector2 other) {
        return new Vector2(x / other.getX(), y / other.getY());
    }

    @Override
    public Vector2 divide(double other) {
        return new Vector2(x / other, y / other);
    }
}
