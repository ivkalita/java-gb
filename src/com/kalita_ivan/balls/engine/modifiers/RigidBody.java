package com.kalita_ivan.balls.engine.modifiers;

import com.kalita_ivan.balls.engine.geometry.Vector2;

public class RigidBody extends AbstractModifier implements ModifierInterface {

    private Vector2 speed;
    private Vector2 acceleration;
    private Vector2 position;
    private double mass;

    public RigidBody(String identifier, Vector2 position, Vector2 acceleration, Vector2 speed, double mass) {
        super(identifier);
        this.speed = speed.clone();
        this.acceleration = acceleration.clone();
        this.position = position.clone();
        this.mass = mass;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    Vector2 getSpeed() {
        return speed;
    }

    void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    Vector2 getAcceleration() {
        return acceleration;
    }

    void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    void setPosition(Vector2 position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
