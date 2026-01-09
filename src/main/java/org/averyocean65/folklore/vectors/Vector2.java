package org.averyocean65.folklore.vectors;

public class Vector2 implements VectorBase<Vector2> {
    private float x;
    private float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getMagnitude() {
        return (float)Math.sqrt(x*x + y*y);
    }

    @Override
    public Vector2 getScaled(float factor) {
        return null;
    }

    @Override
    public Vector2 getNormalized() {
        float newX = x / getMagnitude();
        float newY = y / getMagnitude();
        return new Vector2(newX, newY);
    }

    @Override
    public float[] toArray() {
        return new float[] { x, y };
    }
}
