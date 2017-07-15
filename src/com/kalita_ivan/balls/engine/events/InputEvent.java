package com.kalita_ivan.balls.engine.events;

public class InputEvent {
    private double time;

    InputEvent(double time) {
        this.time = time;
    }

    public double getTime() {
        return this.time;
    }
}
