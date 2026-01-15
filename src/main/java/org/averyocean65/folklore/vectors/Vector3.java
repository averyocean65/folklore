package org.averyocean65.folklore.vectors;

public class Vector3 implements VectorBase<Vector3> {
    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double getMagnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public Vector3 getNormalized() {
        return divide(getMagnitude());
    }

    @Override
    public double[] toArray() {
        return new double[] { x, y, z };
    }

    @Override
    public Vector3 add(Vector3 other) {
        return new Vector3(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        return new Vector3(x - other.getX(), y - other.getY(), z - other.getZ());
    }

    @Override
    public Vector3 multiply(Vector3 other) {
        return new Vector3(x * other.getX(), y * other.getY(), z * other.getZ());
    }

    @Override
    public Vector3 multiply(double other) {
        return new Vector3(x * other, y * other, z * other);
    }

    @Override
    public Vector3 divide(Vector3 other) {
        return new Vector3(x / other.getX(), y / other.getY(), z / other.getZ());
    }

    @Override
    public Vector3 divide(double other) {
        return new Vector3(x / other, y / other, z / other);
    }
}
