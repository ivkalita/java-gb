package com.kalita_ivan.balls.engine.modifiers;

public class Transition extends AbstractModifier implements ModifierInterface {
    private double speed;
    private double value;
    private double min;
    private double max;

    public Transition(String identifier, double speed, double initial, double min, double max) {
        super(identifier);
        this.max = max;
        this.min = min;
        this.speed = speed;
        this.value = initial;
    }

    void calculate(double delta) {
        double value = this.value + this.speed * delta;
        if (value < this.min) {
            value = this.min;
            this.speed = this.speed * -1;
        } else if (value > this.max) {
            value = this.max;
            this.speed = this.speed * -1;
        }
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
