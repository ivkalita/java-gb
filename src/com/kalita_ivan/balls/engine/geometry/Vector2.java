package com.kalita_ivan.balls.engine.geometry;


public class Vector2 implements Cloneable {
    private double x;
    private double y;

    public Vector2 clone() {
        return new Vector2(this.x, this.y);
    }

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

    public Vector2 add(Vector2 that) {
        return new Vector2(this.x + that.x, this.y + that.y);
    }

    public Vector2 multiply(Vector2 that) {
        return new Vector2(this.x * that.x, this.y * that.y);
    }

    public Vector2 multiply(double multiplier) {
        return new Vector2(this.x * multiplier, this.y * multiplier);
    }

    public Vector2 multiply(double x, double y) {
        return new Vector2(this.x * x, this.y * y);
    }
}
