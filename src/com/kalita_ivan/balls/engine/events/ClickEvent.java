package com.kalita_ivan.balls.engine.events;

import com.kalita_ivan.balls.engine.geometry.Vector2;

public class ClickEvent extends InputEvent {
    private Vector2 position;

    public ClickEvent(double time, double x, double y) {
        super(time);
        this.position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
